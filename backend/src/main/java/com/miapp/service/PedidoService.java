package com.miapp.service;

import org.springframework.stereotype.Service;

import com.miapp.entity.PedidoEntity;
import com.miapp.repository.PedidoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	/**
	 * Metodo para llevar control sobr eel estado del pedido
	 * 
	 * @param pedido
	 * @return
	 */
	@Transactional
	public PedidoEntity crearPedido(PedidoEntity pedido) {
		return pedidoRepository.save(pedido);
	}
}
