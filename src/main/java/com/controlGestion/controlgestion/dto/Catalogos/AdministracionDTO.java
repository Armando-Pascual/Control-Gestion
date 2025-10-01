package com.controlGestion.controlgestion.dto.Catalogos;

import java.time.LocalDateTime;


public class AdministracionDTO {
    private Integer cveIdAdministracion;
    private String acronimo;
    private LocalDateTime fecRegistroAlta;
    private LocalDateTime fecRegistroBaja;
    private String administracion;
    private String puesto;
    private Integer cveIdAdmonCentral;
    public Integer getCveIdAdministracion() {
        return cveIdAdministracion;
    }
    public void setCveIdAdministracion(Integer cveIdAdministracion) {
        this.cveIdAdministracion = cveIdAdministracion;
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
    public Integer getCveIdAdmonCentral() {
        return cveIdAdmonCentral;
    }
    public void setCveIdAdmonCentral(Integer cveIdAdmonCentral) {
        this.cveIdAdmonCentral = cveIdAdmonCentral;
    }

    
}
