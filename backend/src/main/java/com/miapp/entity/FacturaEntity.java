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
@Table(name = "factura")
public class FacturaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private Integer idFactura;

	@Column(name = "fecha_emision")
	private LocalDate fechaEmision;

	private Double total;

	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "id_usuario")
	private Integer idUsuario;
}
