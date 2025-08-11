package com.miapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.entity.FacturaEntity;

public interface FacturaRepository extends JpaRepository<FacturaEntity, Integer> {
}
