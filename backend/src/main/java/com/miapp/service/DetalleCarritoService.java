package com.miapp.service;

import org.springframework.stereotype.Service;

import com.miapp.entity.DetalleCarritoEntity;
import com.miapp.repository.DetalleCarritoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleCarritoService {

	private final DetalleCarritoRepository detalleCarritoRepository;

	/**
	 * Crea registro en detalle carrito
	 * @param detalle
	 * @return
	 */
	@Transactional
	public DetalleCarritoEntity crearDetalleCarrito(DetalleCarritoEntity detalle) {
		return detalleCarritoRepository.save(detalle);
	}
}
