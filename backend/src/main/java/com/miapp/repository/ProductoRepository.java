package com.miapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	Optional<Producto> findByNombreContainingIgnoreCase(String nombre);
}

