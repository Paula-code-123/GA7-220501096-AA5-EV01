package com.miapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.entity.FacturaEntity;
import com.miapp.service.FacturaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/facturas")
@RequiredArgsConstructor
public class FacturaController {

	private final FacturaService facturaService;

	/**
	 * Guarda los atos de la factura, retona status 200
	 * 
	 * @param factura
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Void> crearFactura(@RequestBody FacturaEntity factura) {
		facturaService.crearFactura(factura);
		return ResponseEntity.ok().build();
	}
}
