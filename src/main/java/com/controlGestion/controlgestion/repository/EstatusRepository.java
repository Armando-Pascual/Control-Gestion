package com.controlGestion.controlgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlGestion.controlgestion.model.EstatusModel;

public interface EstatusRepository extends JpaRepository<EstatusModel, Integer> {

}
