package com.miapp.service;

import org.springframework.stereotype.Service;

import com.miapp.entity.FacturaEntity;
import com.miapp.repository.FacturaRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacturaService {

	private final FacturaRepository facturaRepository;

	/**
	 * Guarda los datos de la factura
	 * 
	 * @param factura
	 * @return
	 */
	@Transactional
	public void crearFactura(FacturaEntity factura) {
		facturaRepository.save(factura);
	}
}
