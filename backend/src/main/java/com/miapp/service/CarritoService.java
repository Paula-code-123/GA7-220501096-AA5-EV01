package com.miapp.service;

import org.springframework.stereotype.Service;

import com.miapp.entity.CarritoEntity;
import com.miapp.repository.CarritoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarritoService {

	private final CarritoRepository carritoRepository;

	/**
	 * Crea el carrito del usuario
	 * 
	 * @param carrito
	 * @return
	 */
	@Transactional
	public void crearCarrito(CarritoEntity carrito) {
		 carritoRepository.save(carrito);
	}
}
