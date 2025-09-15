package com.controlGestion.controlgestion.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlGestion.controlgestion.dto.RemitenteDTO;
import com.controlGestion.controlgestion.model.RemitenteModel;
import com.controlGestion.controlgestion.repository.RemitenteRepository;
import com.controlGestion.controlgestion.service.RemitenteService;

@RestController
@RequestMapping("/api/remitente")
public class RemitenteController {

    @Autowired
    private RemitenteService service;

     @Autowired
    private RemitenteRepository repository;

    @PostMapping
    public ResponseEntity<RemitenteModel> crearRemitente(@RequestBody RemitenteDTO dto) {
        RemitenteModel nuevo = service.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

@GetMapping("/nombres")
public ResponseEntity<List<String>> obtenerNombres() {
    List<String> nombres = repository.findAll()
        .stream()
        .map(r -> {
            String nombreCompleto = String.join(" ",
                Optional.ofNullable(r.getNombre()).orElse(""),
                Optional.ofNullable(r.getPrimerApellido()).orElse(""),
                Optional.ofNullable(r.getSegundoApellido()).orElse("")
            ).trim();
            return nombreCompleto;
        })
        .filter(nombre -> !nombre.isEmpty())
        .distinct()
        .collect(Collectors.toList());

    return ResponseEntity.ok(nombres);
}



}
