package com.miapp.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleCarritoId implements Serializable {

	private static final long serialVersionUID = 869855797518528004L;
	
	private Integer idCarrito;
    private Integer idProducto;
}
