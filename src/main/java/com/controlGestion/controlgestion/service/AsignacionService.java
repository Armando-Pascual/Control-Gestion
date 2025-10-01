package com.controlGestion.controlgestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.AsignacionDTO;
import com.controlGestion.controlgestion.model.AsignacionModel;
import com.controlGestion.controlgestion.repository.AsignacionRepository;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;


    public AsignacionModel crearAsignacion(AsignacionDTO dto) {
       

        AsignacionModel asignacion = new AsignacionModel();
        asignacion.setFecAsignacion(dto.getFecAsignacion());
        asignacion.setFecRegistroAlta(dto.getFecRegistroAlta());
        asignacion.setFecRegistroBaja(dto.getFecRegistroBaja());
        asignacion.setNombreAsignado(dto.getNombreAsignado());
        asignacion.setPrimerApellidoAsignado(dto.getPrimerApellidoAsignado());
        asignacion.setSegundoApellidoAsignado(dto.getSegundoApellidoAsignado());

        return asignacionRepository.save(asignacion);
    }
}

