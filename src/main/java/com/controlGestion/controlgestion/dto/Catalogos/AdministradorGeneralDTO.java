package com.controlGestion.controlgestion.dto.Catalogos;

import java.time.LocalDateTime;


public class AdministradorGeneralDTO {
    private Integer cveIdAdministradorGeneral;
    private String correo;
    private LocalDateTime fecRegistroAlta;
    private String nombreAdministrador;
    private String primerApellidoAdministrador;
    private String segundoApellidoAdministrador;
    private Integer cveIdAdmonGeneral;
    public Integer getCveIdAdministradorGeneral() {
        return cveIdAdministradorGeneral;
    }
    public void setCveIdAdministradorGeneral(Integer cveIdAdministradorGeneral) {
        this.cveIdAdministradorGeneral = cveIdAdministradorGeneral;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public LocalDateTime getFecRegistroAlta() {
        return fecRegistroAlta;
    }
    public void setFecRegistroAlta(LocalDateTime fecRegistroAlta) {
        this.fecRegistroAlta = fecRegistroAlta;
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
    public Integer getCveIdAdmonGeneral() {
        return cveIdAdmonGeneral;
    }
    public void setCveIdAdmonGeneral(Integer cveIdAdmonGeneral) {
        this.cveIdAdmonGeneral = cveIdAdmonGeneral;
    }  



}
