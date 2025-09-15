package com.controlGestion.controlgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controlGestion.controlgestion.model.RemitenteModel;

@Repository
public interface RemitenteRepository extends JpaRepository<RemitenteModel, Integer> {
}

