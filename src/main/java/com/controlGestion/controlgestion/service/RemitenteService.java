package com.controlGestion.controlgestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.RemitenteDTO;
import com.controlGestion.controlgestion.model.RemitenteModel;
import com.controlGestion.controlgestion.repository.RemitenteRepository;

@Service
public class RemitenteService {

    @Autowired
    private RemitenteRepository repository;

    public RemitenteModel guardar(RemitenteDTO dto) {
        RemitenteModel remitente = new RemitenteModel();
        remitente.setArea(dto.getArea());
        remitente.setFecRegistroAlta(dto.getFecRegistroAlta());
        remitente.setFecRegistroBaja(dto.getFecRegistroBaja());
        remitente.setNombre(dto.getNombre());
        remitente.setPrimerApellido(dto.getPrimerApellido());
        remitente.setSegundoApellido(dto.getSegundoApellido());
        remitente.setPuesto(dto.getPuesto());
        return repository.save(remitente);
    }
}
