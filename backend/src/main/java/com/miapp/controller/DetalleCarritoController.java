package com.miapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.entity.DetalleCarritoEntity;
import com.miapp.service.DetalleCarritoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detalles-carrito")
@RequiredArgsConstructor
public class DetalleCarritoController {

	private final DetalleCarritoService detalleCarritoService;

	/**
	 * Metodo para llevar registro del detalle del carriot del usuario
	 * 
	 * @param detalle
	 * @return
	 */
	@PostMapping
	public ResponseEntity<DetalleCarritoEntity> crearDetalle(@RequestBody DetalleCarritoEntity detalle) {
		return ResponseEntity.status(HttpStatus.CREATED).body(detalleCarritoService.crearDetalleCarrito(detalle));
	}
}
