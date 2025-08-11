package com.miapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.entity.PagoEntity;

public interface PagoRepository extends JpaRepository<PagoEntity, Integer> {
}
