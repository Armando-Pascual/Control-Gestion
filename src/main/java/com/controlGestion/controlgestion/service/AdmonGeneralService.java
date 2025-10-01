package com.controlGestion.controlgestion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.Catalogos.AdmonGeneralDTO;
import com.controlGestion.controlgestion.mapper.CatalogoMapper;
import com.controlGestion.controlgestion.repository.AdmonGeneralRepository;

@Service
public class AdmonGeneralService {

    @Autowired
    private AdmonGeneralRepository repositorio;

    public List<AdmonGeneralDTO> obtenerDTOs() {
        return repositorio.findAll().stream()
            .map(CatalogoMapper::toAdmonGeneralDTO)
            .collect(Collectors.toList());
    }
}

