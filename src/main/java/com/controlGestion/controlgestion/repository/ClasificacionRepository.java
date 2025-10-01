package com.controlGestion.controlgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlGestion.controlgestion.model.ClasificacionModel;

public interface ClasificacionRepository extends  JpaRepository <ClasificacionModel, Integer> {

}
