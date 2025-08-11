package com.miapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pago")
public class PagoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago")
	private Integer idPago;

	@Column(name = "fecha_pago")
	private LocalDate fechaPago;

	private Double monto;

	@Column(name = "metodo_pago")
	private String metodoPago;

	@Column(name = "id_pedido")
	private Integer idPedido;
}
