package com.controlGestion.controlgestion.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EstadoDTO {
    private Integer id;
    private Integer estado;
    private LocalDateTime fecActualizacion;
    private String comentarios;
    private Integer cveIdSolicitud;
}
