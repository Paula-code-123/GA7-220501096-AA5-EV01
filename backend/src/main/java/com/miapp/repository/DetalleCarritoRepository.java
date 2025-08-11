package com.miapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.dto.DetalleCarritoId;
import com.miapp.entity.DetalleCarritoEntity;

public interface DetalleCarritoRepository extends JpaRepository<DetalleCarritoEntity, DetalleCarritoId> {
}
