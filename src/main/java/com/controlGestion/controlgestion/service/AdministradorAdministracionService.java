package com.controlGestion.controlgestion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.Catalogos.AdministradorAdministracionDTO;
import com.controlGestion.controlgestion.mapper.CatalogoMapper;
import com.controlGestion.controlgestion.repository.AdministradorAdministracionRepository;

@Service
public class AdministradorAdministracionService {

    @Autowired
    private AdministradorAdministracionRepository repositorio;

    public List<AdministradorAdministracionDTO> obtenerDTOs() {
        return repositorio.findAll().stream()
            .map(CatalogoMapper::toAdministradorAdministracionDTO)
            .collect(Collectors.toList());
    }
}
