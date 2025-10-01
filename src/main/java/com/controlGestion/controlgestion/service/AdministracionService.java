package com.controlGestion.controlgestion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.Catalogos.AdministracionDTO;
import com.controlGestion.controlgestion.mapper.CatalogoMapper;
import com.controlGestion.controlgestion.repository.AdministracionRepository;

@Service
public class AdministracionService {

    @Autowired
    private AdministracionRepository repositorio;

    public List<AdministracionDTO> obtenerDTOs() {
        return repositorio.findAll().stream()
            .map(CatalogoMapper::toAdministracionDTO)
            .collect(Collectors.toList());
    }
}
