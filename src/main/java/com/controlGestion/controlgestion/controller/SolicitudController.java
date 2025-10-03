package com.controlGestion.controlgestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlGestion.controlgestion.dto.SolicitudDTO;
import com.controlGestion.controlgestion.mapper.SolicitudMapper;
import com.controlGestion.controlgestion.model.SolicitudModel;
import com.controlGestion.controlgestion.service.SolicitudService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private SolicitudMapper solicitudMapper;


    // Consulta todas las solicitudes existentes
    @GetMapping
    public ResponseEntity<List<SolicitudDTO>> obtenerTodasLasSolicitudes() {
        List<SolicitudModel> solicitudes = solicitudService.obtenerTodas();
        List<SolicitudDTO> dtos = solicitudes.stream()
                .map(solicitudMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    // Consulta una solicitud por ID
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> obtenerPorId(@PathVariable Integer id) {
        SolicitudModel solicitud = solicitudService.obtenerPorId(id);
        SolicitudDTO dto = solicitudMapper.toDTO(solicitud);
        return ResponseEntity.ok(dto);
    }

    /*/ Consulta el historial de estados de una solicitud
    @GetMapping("/{id}/historial")
    public ResponseEntity<List<EstadoDTO>> obtenerHistorialDeEstados(@PathVariable Integer id) {
        List<EstadoModel> historial = estadoRepository.findBySolicitudCveIdSolicitud(id);
        List<EstadoDTO> dtoList = historial.stream()
                .map(estadoMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtoList);
    }*/
}
