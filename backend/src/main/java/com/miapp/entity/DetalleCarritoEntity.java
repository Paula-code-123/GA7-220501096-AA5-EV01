package com.miapp.entity;

import com.miapp.dto.DetalleCarritoId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detallecarrito")
@IdClass(DetalleCarritoId.class)
public class DetalleCarritoEntity {

	@Id
	@Column(name = "id_carrito")
	private Integer idCarrito;

	@Id
	@Column(name = "id_producto")
	private Integer idProducto;

	private Integer cantidad;
}
