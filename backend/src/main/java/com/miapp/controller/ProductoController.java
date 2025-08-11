package com.miapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.dto.ProductoRequest;
import com.miapp.entity.Producto;
import com.miapp.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	/**
	 * Metdo para crear un producto nuevo
	 * @param request
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Map<String, String>> crearProducto(@RequestBody ProductoRequest request) {
		productoService.crearProducto(request);

		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("mensaje", "Producto creado exitosamente");

		return ResponseEntity.ok(respuesta);
	}
	
	/**
	 * Método para  consultar un producto pr su id
	 * @param id
	 * @return
	 */
	@GetMapping("/{nombre}")
	public ResponseEntity<Producto> obtenerProducto(@PathVariable String nombre) {
	    Producto producto = productoService.obtenerProductoPorId(nombre);
	    return ResponseEntity.ok(producto);
	}

	/**
	 * Método para obtener todos los productos
	 * @return
	 */
	@GetMapping
	public  ResponseEntity<?> obtenerTodosProductos() {
		 return ResponseEntity.ok(productoService.obtenerTodosProductos());
	}
	
	/**
	 * Métdo para  actualizar un producto por su id
	 * @param id
	 * @param request
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, String>> actualizarProducto(@PathVariable Integer id,
			@RequestBody ProductoRequest request) {
		productoService.actualizarProducto(id, request);

		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("mensaje", "Producto actualizado exitosamente");

		return ResponseEntity.ok(respuesta);
	}

	/**
	 * Método para eliminar prducto por su id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> eliminarProducto(@PathVariable Integer id) {
		productoService.eliminarProducto(id);

		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("mensaje", "Producto eliminado exitosamente");

		return ResponseEntity.ok(respuesta);
	}

}
