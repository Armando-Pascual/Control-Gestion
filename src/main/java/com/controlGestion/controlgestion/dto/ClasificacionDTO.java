package com.controlGestion.controlgestion.dto;

import java.time.LocalDateTime;

public class ClasificacionDTO {

    private Integer idTipoClasificacion;
    private String desClasificacion;
    private LocalDateTime fecRegistroAlta;
    private LocalDateTime fecRegistroBaja;

    public Integer getIdTipoClasificacion() {
        return idTipoClasificacion;
    }
    
    public void setIdTipoClasificacion(Integer idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }

    public String getDesClasificacion() {
        return desClasificacion;
    }
    public void setDesClasificacion(String desClasificacion) {
        this.desClasificacion = desClasificacion;
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

    

}
