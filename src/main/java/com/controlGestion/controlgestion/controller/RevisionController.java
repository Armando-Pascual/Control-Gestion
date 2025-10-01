package com.controlGestion.controlgestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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

   /*  @PutMapping("/solicitud/{id}/estado/proceso-entrega")
    public ResponseEntity<SolicitudDTO> actualizarAProcesoEntrega(
            @PathVariable Integer id,
            @Validated @RequestBody ActualizarSolicitudDTO datos) {

        SolicitudModel actualizada = solicitudService.actualizarEstatusYDocumento(
                id, EstatusEnum.PROCESO_DE_ENTREGA, datos.getCveIdDocumento(), datos.getComentarios(),datos.getReasignado());

        SolicitudDTO dto = solicitudMapper.toDTO(actualizada);
        return ResponseEntity.ok(dto);
    }
        */
        //Se comenta metodo ya que se unifica con el de actualizarEstadoAsignacion

    @PutMapping("/{id}/estado/asignacion")
    public ResponseEntity<SolicitudDTO> actualizarEstadoAsignacion(
            @PathVariable Integer id,
            @Validated @RequestBody ActualizarSolicitudDTO datos) {

        SolicitudModel solicitud = solicitudService.obtenerPorId(id);
        Integer estadoActualId = solicitud.getEstatus().getId();

        if (estadoActualId != EstatusEnum.REVISION.getId()) {
            throw new IllegalStateException("La solicitud no puede avanzar desde el estado actual: " + estadoActualId);
        }

        EstatusEnum nuevoEstatus = Boolean.TRUE.equals(datos.getReasignado())
                ? EstatusEnum.ASIGNADA
                : EstatusEnum.PROCESO_DE_ENTREGA;

        SolicitudModel actualizada = solicitudService.actualizarEstatusYDocumento(
                id, nuevoEstatus, datos.getCveIdDocumento(), datos.getComentarios(), datos.getReasignado());

        SolicitudDTO dto = solicitudMapper.toDTO(actualizada);
        return ResponseEntity.ok(dto);
    }

}
