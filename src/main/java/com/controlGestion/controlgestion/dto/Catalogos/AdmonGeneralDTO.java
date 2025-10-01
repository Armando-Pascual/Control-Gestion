package com.controlGestion.controlgestion.dto.Catalogos;

import java.time.LocalDateTime;

public class AdmonGeneralDTO {
    public Integer cveIdAdmonGeneral;  
    public String acronimo;
    public LocalDateTime fecRegistroAlta;
    public LocalDateTime fecRegistroBaja;
    private String administracion;
    private String puesto;
    public Integer getCveIdAdmonGeneral() {
        return cveIdAdmonGeneral;
    }
    public void setCveIdAdmonGeneral(Integer cveIdAdmonGeneral) {
        this.cveIdAdmonGeneral = cveIdAdmonGeneral;
    }
    public String getAcronimo() {
        return acronimo;
    }
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
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
    public String getAdministracion() {
        return administracion;
    }
    public void setAdministracion(String administracion) {
        this.administracion = administracion;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    } 

    

}
