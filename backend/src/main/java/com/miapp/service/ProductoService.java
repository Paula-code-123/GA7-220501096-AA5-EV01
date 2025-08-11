package com.miapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miapp.dto.ProductoRequest;
import com.miapp.entity.Producto;
import com.miapp.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional
    public void crearProducto(ProductoRequest request) {
    	//Crea un nuevo objeto producto, l setea con los valores enviados
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setIdCategoria(request.getIdCategoria());

        productoRepository.save(producto);
    }

    @Transactional(readOnly = true)
    public Producto obtenerProductoPorId(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    /**
     * Consulta todos los productos disponibles
     * @return
     */
    @Transactional(readOnly = true)
    public List<Producto> obtenerTodosProductos() {
    	return productoRepository.findAll();
    }
    
    @Transactional
    public void actualizarProducto(Integer id, ProductoRequest request) {
    	//Busca producto por id, sino lo encuentra lanza exception
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        
        //Setea el producto con los nuevos valores
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());
        producto.setIdCategoria(request.getIdCategoria());

        productoRepository.save(producto);
    }

    @Transactional
    public void eliminarProducto(Integer id) {
    	//Busca producto por id, sino lo encuentra lanza exception
        Producto producto = productoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        productoRepository.delete(producto);
    }
    
    
}

