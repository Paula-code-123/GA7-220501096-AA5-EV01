package com.miapp.service;

import org.springframework.stereotype.Service;

import com.miapp.entity.PagoEntity;
import com.miapp.repository.PagoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoService {

	private final PagoRepository pagoRepository;

	/**
	 * Guarda la información del pago
	 * 
	 * @param pago
	 */
	@Transactional
	public void crearPago(PagoEntity pago) {
		pagoRepository.save(pago);
	}
}
