package com.controlGestion.controlgestion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.Catalogos.AdministradorCentralDTO;
import com.controlGestion.controlgestion.mapper.CatalogoMapper;
import com.controlGestion.controlgestion.repository.AdministradorCentralRepository;

@Service
public class AdministradorCentralService {

    @Autowired
    private AdministradorCentralRepository repositorio;

    public List<AdministradorCentralDTO> obtenerDTOs() {
        return repositorio.findAll().stream()
            .map(CatalogoMapper::toAdministradorCentralDTO)
            .collect(Collectors.toList());
    }
}

