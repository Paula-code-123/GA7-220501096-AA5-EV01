package com.miapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.entity.PagoEntity;
import com.miapp.service.PagoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

	   private final PagoService pagoService;

	   /**
	    * Guarda el pago
	    * @param pago
	    * @return
	    */
	    @PostMapping("/guardar")
	    public ResponseEntity<Void> crearPago(@RequestBody PagoEntity pago) {
	    	pagoService.crearPago(pago);
	        return ResponseEntity.ok().build();
	    }
}
