package com.miapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miapp.entity.UsuarioEntity;
import com.miapp.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	private final UsuarioService usuarioService;

	/**
	 * Método para crear usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Map<String, String>> crearUsuario(@RequestBody UsuarioEntity usuario) {
		usuarioService.crearUsuario(usuario);
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("mensaje", "Usuario creado exitosamente");

		return ResponseEntity.ok(respuesta);
	}

	/**
	 * Login usuario
	 * 
	 * @param correo
	 * @param contraseña
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String correo, @RequestParam String contrasena) {

		if (usuarioService.validarUsuario(correo, contrasena)) {
			return ResponseEntity.ok("Credenciales correctas");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
		}
	}
}
