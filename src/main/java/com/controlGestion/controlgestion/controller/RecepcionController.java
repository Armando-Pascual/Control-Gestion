package com.controlGestion.controlgestion.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlGestion.controlgestion.dto.SolicitudDTO;
import com.controlGestion.controlgestion.mapper.SolicitudMapper;
import com.controlGestion.controlgestion.model.ClasificacionModel;
import com.controlGestion.controlgestion.model.SolicitudModel;
import com.controlGestion.controlgestion.model.Enum.EstatusEnum;
import com.controlGestion.controlgestion.repository.ClasificacionRepository;
import com.controlGestion.controlgestion.service.SolicitudService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/recepcion")
@PreAuthorize("hasRole('RECEPCION')")
public class RecepcionController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private SolicitudMapper solicitudMapper;

    @PostMapping("/solicitud")
    public ResponseEntity<SolicitudModel> crearSolicitud(@RequestBody SolicitudDTO dto) {
        SolicitudModel nueva = solicitudService.crearSolicitud(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @GetMapping("/clasificaciones")
    public ResponseEntity<List<ClasificacionModel>> obtenerClasificaciones() {
        List<ClasificacionModel> lista = clasificacionRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/solicitud/{id}/fecha-baja")
    public ResponseEntity<SolicitudModel> actualizarFechaBaja(@PathVariable Integer id,
            @RequestBody Map<String, String> body) {

        LocalDateTime fechaBaja = LocalDateTime.parse(body.get("fechaBaja"));
        SolicitudModel actualizada = solicitudService.actualizarFechaBaja(id, fechaBaja);
        return ResponseEntity.ok(actualizada);
    }

    @PutMapping("/solicitud/{id}/finalizar")
    @PreAuthorize("hasRole('RECEPCION')")
    public ResponseEntity<SolicitudDTO> actualizarAFinalizar(@PathVariable Integer id) {
        SolicitudModel actualizada = solicitudService.actualizarEstatus(id, EstatusEnum.ATENDIDA);
        SolicitudDTO dto = solicitudMapper.toDTO(actualizada);
        return ResponseEntity.ok(dto);
    }

}
