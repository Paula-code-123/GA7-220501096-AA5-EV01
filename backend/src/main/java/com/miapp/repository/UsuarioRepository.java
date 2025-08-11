package com.miapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

	// Busca si existe usuario con el mismo corre
	boolean existsByCorreo(String correo);

	// Consulta si el usuario y contraseña son correctos
	Optional<UsuarioEntity> findByCorreoAndPassword(String correo, String contraseña);
}
