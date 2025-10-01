package com.controlGestion.controlgestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/revision")
@PreAuthorize("hasRole('REVISION')")
public class RevisionController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private SolicitudMapper solicitudMapper;

@PutMapping("/solicitud/{id}/estado/proceso-entrega")
public ResponseEntity<SolicitudDTO> actualizarAProcesoEntrega(
        @PathVariable Integer id,
        @RequestBody ActualizarSolicitudDTO datos) {

    SolicitudModel actualizada = solicitudService.actualizarEstatusYDocumento(
        id, EstatusEnum.PROCESO_DE_ENTREGA, datos.getCveIdDocumento());

    SolicitudDTO dto = solicitudMapper.toDTO(actualizada);
    return ResponseEntity.ok(dto);
}


    @PutMapping("/{id}/estado/asignacion")
    public ResponseEntity<SolicitudDTO> actualizarAAsignacion(@PathVariable Integer id) {
        SolicitudModel solicitud = solicitudService.obtenerPorId(id);
        Integer estadoActualId = solicitud.getEstatus().getId();

        SolicitudModel actualizada;

        if (estadoActualId == EstatusEnum.REVISION.getId() && Boolean.TRUE.equals(solicitud.getReasignado())) {
            actualizada = solicitudService.actualizarEstatus(id, EstatusEnum.ASIGNADA);
        } else {
            throw new IllegalStateException(
                    "La solicitud no puede avanzar desde el estado actual: " + estadoActualId);
        }

        SolicitudDTO dto = solicitudMapper.toDTO(actualizada);
        return ResponseEntity.ok(dto);
    }
    
}
