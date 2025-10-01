package com.controlGestion.controlgestion.dto.Catalogos;

import java.time.LocalDateTime;

 
public class AdministradorCentralDTO {
    public Integer cveIdAdministradorCentral;
    public LocalDateTime fecRegistroAlta;
    public LocalDateTime fecRegistroBaja;
    public String nombreAdministrador;    
    public String primerApellidoAdministrador;
    public String segundoApellidoAdministrador;
    public Integer cveIdAdmonCentral;
    public Integer getCveIdAdministradorCentral() {
        return cveIdAdministradorCentral;
    }
    public void setCveIdAdministradorCentral(Integer cveIdAdministradorCentral) {
        this.cveIdAdministradorCentral = cveIdAdministradorCentral;
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
    public String getNombreAdministrador() {
        return nombreAdministrador;
    }
    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }
    public String getPrimerApellidoAdministrador() {
        return primerApellidoAdministrador;
    }
    public void setPrimerApellidoAdministrador(String primerApellidoAdministrador) {
        this.primerApellidoAdministrador = primerApellidoAdministrador;
    }
    public String getSegundoApellidoAdministrador() {
        return segundoApellidoAdministrador;
    }
    public void setSegundoApellidoAdministrador(String segundoApellidoAdministrador) {
        this.segundoApellidoAdministrador = segundoApellidoAdministrador;
    }
    public Integer getCveIdAdmonCentral() {
        return cveIdAdmonCentral;
    }
    public void setCveIdAdmonCentral(Integer cveIdAdmonCentral) {
        this.cveIdAdmonCentral = cveIdAdmonCentral;
    }

    

}
