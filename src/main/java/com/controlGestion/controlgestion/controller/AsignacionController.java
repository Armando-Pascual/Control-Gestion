package com.controlGestion.controlgestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlGestion.controlgestion.dto.ActualizarSolicitudDTO;
import com.controlGestion.controlgestion.dto.SolicitudDTO;
import com.controlGestion.controlgestion.mapper.SolicitudMapper;
import com.controlGestion.controlgestion.model.SolicitudModel;
import com.controlGestion.controlgestion.model.Enum.EstatusEnum;
import com.controlGestion.controlgestion.service.SolicitudService;

@RestController
@RequestMapping("/api/asignacion")

@PreAuthorize("hasRole('ASIGNADOR')")
public class AsignacionController {

    @Autowired
    private SolicitudMapper solicitudMapper;

    @Autowired
    private SolicitudService solicitudService;

    // Avanza el estado de una solicitud a "En Revisión" o "Documento Acuse" según
    // corresponda
    @PutMapping("/{id}/estado/revision")
    public ResponseEntity<SolicitudDTO> actualizarARevision(@PathVariable Integer id,
    @RequestBody ActualizarSolicitudDTO datos) {
        SolicitudModel solicitud = solicitudService.obtenerPorId(id);
        Integer estadoActualId = solicitud.getEstatus().getId();

        SolicitudModel actualizada;

        if (estadoActualId == EstatusEnum.ASIGNADA.getId()) {
            actualizada = solicitudService.actualizarEstatusYDocumento(id, EstatusEnum.REVISION, null, datos.getComentarios(), null);
        } else if (estadoActualId == EstatusEnum.PROCESO_DE_ENTREGA.getId()) {
            actualizada = solicitudService.actualizarEstatusYDocumento(id, EstatusEnum.DOCUMENTO_ACUSE, null, datos.getComentarios(), null);
        } else {
            throw new IllegalStateException(
                    "La solicitud no puede avanzar desde el estado actual: " + estadoActualId);
        }
        //esta validacion complementa la regla de reproceso, por medio del estado

        SolicitudDTO dto = solicitudMapper.toDTO(actualizada);
        return ResponseEntity.ok(dto);
    }

        @PostMapping("/solicitud/asignacion")
        public ResponseEntity<SolicitudModel> crearSolicitudAsinacion(@RequestBody SolicitudDTO dto) {
        SolicitudModel nueva = solicitudService.crearSolicitudAsignacion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }
}