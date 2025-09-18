package com.controlGestion.controlgestion.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class RemitenteDTO {
    private String area;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String puesto;

}
