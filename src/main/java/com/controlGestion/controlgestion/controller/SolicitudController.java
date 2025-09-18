package com.controlGestion.controlgestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlGestion.controlgestion.dto.SolicitudDTO;
import com.controlGestion.controlgestion.model.SolicitudModel;
import com.controlGestion.controlgestion.service.SolicitudService;

@RestController
@RequestMapping("/api/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @PreAuthorize("hasRole('RECEPCION')")
    @PostMapping
    public ResponseEntity<SolicitudModel> crearSolicitud(@RequestBody SolicitudDTO dto) {
        SolicitudModel nueva = solicitudService.crearSolicitud(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }
}
