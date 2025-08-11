package com.miapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.entity.CarritoEntity;
import com.miapp.service.CarritoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/carritos")
@RequiredArgsConstructor
public class CarritoController {

	private final CarritoService carritoService;

	/**
	 * Meotod para crear un carrito, no retorna información
	 * @param carrito
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Void> crearCarrito(@RequestBody CarritoEntity carrito) {
		carritoService.crearCarrito(carrito);
		return ResponseEntity.noContent().build();
	}
}
