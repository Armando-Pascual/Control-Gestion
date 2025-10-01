package com.controlGestion.controlgestion.dto.Catalogos;

import java.time.LocalDateTime;

public class AdmonCentralDTO {
    private Integer cveIdAdmonCentral;
    private String acronimo;
    private LocalDateTime fecRegistroAlta;  
    private LocalDateTime fecRegistroBaja;
    private String administracion;
    private String puesto;
    private Integer cveIdAdmonGeneral;
    public Integer getCveIdAdmonCentral() {
        return cveIdAdmonCentral;
    }
    public void setCveIdAdmonCentral(Integer cveIdAdmonCentral) {
        this.cveIdAdmonCentral = cveIdAdmonCentral;
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
    public Integer getCveIdAdmonGeneral() {
        return cveIdAdmonGeneral;
    }
    public void setCveIdAdmonGeneral(Integer cveIdAdmonGeneral) {
        this.cveIdAdmonGeneral = cveIdAdmonGeneral;
    }


    
}
