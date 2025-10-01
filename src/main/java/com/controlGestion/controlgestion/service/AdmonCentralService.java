package com.controlGestion.controlgestion.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.Catalogos.AdmonCentralDTO;
import com.controlGestion.controlgestion.mapper.CatalogoMapper;
import com.controlGestion.controlgestion.repository.AdmonCentralRepository;

@Service
public class AdmonCentralService {

    @Autowired
    private AdmonCentralRepository repositorio;

    public List<AdmonCentralDTO> obtenerDTOs() {
        return repositorio.findAll().stream()
            .map(CatalogoMapper::toAdmonCentralDTO)
            .collect(Collectors.toList());
    }
}

