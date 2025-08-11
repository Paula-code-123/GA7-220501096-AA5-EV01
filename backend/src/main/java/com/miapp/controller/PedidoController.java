package com.miapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.entity.PedidoEntity;
import com.miapp.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoService pedidoService;

	/**
	 * Metodo para llevar control sobr eel estado del pedido
	 * 
	 * @param pedido
	 * @return
	 */
	@PostMapping
	public ResponseEntity<PedidoEntity> crearPedido(@RequestBody PedidoEntity pedido) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.crearPedido(pedido));
	}
}
