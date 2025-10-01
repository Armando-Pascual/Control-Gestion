package com.controlGestion.controlgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlGestion.controlgestion.model.AdministracionModel;

public interface AdministradorRepository extends JpaRepository< AdministracionModel, Integer> {

}
