package com.controlGestion.controlgestion.dto;

public class UsuarioDto {
    private String nombre;
    private String rol;

    public UsuarioDto( String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public UsuarioDto() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
}