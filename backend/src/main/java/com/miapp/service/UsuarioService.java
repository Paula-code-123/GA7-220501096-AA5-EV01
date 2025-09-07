package com.miapp.service;

import org.springframework.stereotype.Service;

import com.miapp.entity.UsuarioEntity;
import com.miapp.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	/**
	 * Guarda en base de datos un nuevo usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@Transactional
	public void crearUsuario(UsuarioEntity usuario) {
		//valida si existe ya un usuario con el mismo correo
		if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
			throw new RuntimeException("Ya existe un usuario con ese correo.");
		}

		usuarioRepository.save(usuario);
	}

	/**
	 * Consulta usuario y contraseña
	 * 
	 * @param correo
	 * @param contrasena
	 * @return
	 */
	public boolean validarUsuario(String correo, String contrasena) {
		return usuarioRepository.findByCorreoAndPassword(correo, contrasena).isPresent();
	}
}
