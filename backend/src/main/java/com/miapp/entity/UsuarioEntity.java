package com.miapp.entity;

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
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;

	private String nombre;
	private String correo;
	private String telefono;
	private String direccion;
	private String ciudad;
	private String departamento;
	private String password;
}
