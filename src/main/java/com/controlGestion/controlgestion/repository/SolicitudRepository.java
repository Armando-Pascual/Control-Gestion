package com.controlGestion.controlgestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlGestion.controlgestion.model.SolicitudModel;

public interface SolicitudRepository extends JpaRepository<SolicitudModel, Integer> {

}
