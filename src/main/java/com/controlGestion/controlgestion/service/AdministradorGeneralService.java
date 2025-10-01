package com.controlGestion.controlgestion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.Catalogos.AdministradorGeneralDTO;
import com.controlGestion.controlgestion.mapper.CatalogoMapper;
import com.controlGestion.controlgestion.repository.AdministradorGeneralRepository;

@Service
public class AdministradorGeneralService {

    @Autowired
    private AdministradorGeneralRepository repositorio;

    public List<AdministradorGeneralDTO> obtenerDTOs() {
        return repositorio.findAll().stream()
            .map(CatalogoMapper::toAdministradorGeneralDTO)
            .collect(Collectors.toList());
    }
}
