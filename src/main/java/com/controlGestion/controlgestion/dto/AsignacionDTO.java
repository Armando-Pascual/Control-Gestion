package com.controlGestion.controlgestion.dto;

import java.time.LocalDateTime;

public class AsignacionDTO {

    private Integer idAsignacion;
    private String nombreAsignado;
    private String primerApellidoAsignado;
    private String segundoApellidoAsignado;
    private LocalDateTime fecAsignacion;
    private LocalDateTime fecRegistroAlta;
    private LocalDateTime fecRegistroBaja;  
    private Integer cveIdAdministradorAdministracion; // Relación foránea


    public String getNombreAsignado() {
        return nombreAsignado;
    }
    public void setNombreAsignado(String nombreAsignado) {
        this.nombreAsignado = nombreAsignado;
    }
    public String getPrimerApellidoAsignado() {
        return primerApellidoAsignado;
    }
    public void setPrimerApellidoAsignado(String primerApellidoAsignado) {
        this.primerApellidoAsignado = primerApellidoAsignado;
    }
    public String getSegundoApellidoAsignado() {
        return segundoApellidoAsignado;
    }
    public void setSegundoApellidoAsignado(String segundoApellidoAsignado) {
        this.segundoApellidoAsignado = segundoApellidoAsignado;
    }
    public LocalDateTime getFecAsignacion() {
        return fecAsignacion;
    }
    public void setFecAsignacion(LocalDateTime fecAsignacion) {
        this.fecAsignacion = fecAsignacion;
    }
    public LocalDateTime getFecRegistroAlta() {
        return fecRegistroAlta;
    }
    public void setFecRegistroAlta(LocalDateTime fecRegistroAlta) {
        this.fecRegistroAlta = fecRegistroAlta;
    }
    public LocalDateTime getFecRegistroBaja() {
        return fecRegistroBaja;
    }
    public void setFecRegistroBaja(LocalDateTime fecRegistroBaja) {
        this.fecRegistroBaja = fecRegistroBaja;
    }
     public Integer getCveIdAdministradorAdministracion() {
        return cveIdAdministradorAdministracion;
    }
    public void setCveIdAdministradorAdministracion(Integer cveIdAdministradorAdministracion) {
        this.cveIdAdministradorAdministracion = cveIdAdministradorAdministracion;
    }
        
    public Integer getIdAsignacion() {
        return idAsignacion;
    }
    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }
    
}
