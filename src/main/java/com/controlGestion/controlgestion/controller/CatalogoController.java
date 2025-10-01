package com.controlGestion.controlgestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlGestion.controlgestion.dto.Catalogos.AdministracionDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdministradorAdministracionDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdministradorCentralDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdministradorGeneralDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdmonCentralDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdmonGeneralDTO;
import com.controlGestion.controlgestion.service.AdministracionService;
import com.controlGestion.controlgestion.service.AdministradorAdministracionService;
import com.controlGestion.controlgestion.service.AdministradorCentralService;
import com.controlGestion.controlgestion.service.AdministradorGeneralService;
import com.controlGestion.controlgestion.service.AdmonCentralService;
import com.controlGestion.controlgestion.service.AdmonGeneralService;

@RestController
@RequestMapping("/api/catalogos")
public class CatalogoController {

    @Autowired private AdministradorGeneralService administradorGeneralService;
    @Autowired private AdministradorCentralService administradorCentralService;
    @Autowired private AdmonGeneralService admonGeneralService;
    @Autowired private AdmonCentralService admonCentralService;
    @Autowired private AdministracionService administracionService;
    @Autowired private AdministradorAdministracionService administradorAdministracionService;

    @GetMapping("/administradores-generales")
    public List<AdministradorGeneralDTO> getAdministradoresGenerales() {
        return administradorGeneralService.obtenerDTOs();
    }

    @GetMapping("/administradores-centrales")
    public List<AdministradorCentralDTO> getAdministradoresCentrales() {
        return administradorCentralService.obtenerDTOs();
    }

    @GetMapping("/admon-generales")
    public List<AdmonGeneralDTO> getAdmonGenerales() {
        return admonGeneralService.obtenerDTOs();
    }

    @GetMapping("/admon-centrales")
    public List<AdmonCentralDTO> getAdmonCentrales() {
        return admonCentralService.obtenerDTOs();
    }

    @GetMapping("/administraciones")
    public List<AdministracionDTO> getAdministraciones() {
        return administracionService.obtenerDTOs();
    }

    @GetMapping("/administradores-admon")
    public List<AdministradorAdministracionDTO> getAdministradoresAdmon() {
        return administradorAdministracionService.obtenerDTOs();
    }
}

