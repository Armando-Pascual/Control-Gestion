package com.controlGestion.controlgestion.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDto {
    private String nombre;
    private String rol;

    public UsuarioDto( String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public UsuarioDto() {

    }
}