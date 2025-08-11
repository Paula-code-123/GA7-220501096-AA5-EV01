package com.miapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.entity.CarritoEntity;

public interface CarritoRepository extends JpaRepository<CarritoEntity, Integer> {
}
