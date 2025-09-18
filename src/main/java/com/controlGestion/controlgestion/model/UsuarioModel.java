package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cgc_usuario", schema = "gestdoc")
public class UsuarioModel {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cve_id_usuario")
    private Integer id;

    @Column(name = "administracion")
    private String administracion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "rfc_corto")
    private String rfcCorto;

    @Column(name = "rfc_largo")
    private String rfcLargo;
    
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "rol", length = 20)
    private String rol; 

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<SolicitudModel> solicitudes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdministracion() {
        return administracion;
    }

    public void setAdministracion(String administracion) {
        this.administracion = administracion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getRfcCorto() {
        return rfcCorto;
    }

    public void setRfcCorto(String rfcCorto) {
        this.rfcCorto = rfcCorto;
    }

    public String getRfcLargo() {
        return rfcLargo;
    }

    public void setRfcLargo(String rfcLargo) {
        this.rfcLargo = rfcLargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public List<SolicitudModel> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudModel> solicitudes) {
        this.solicitudes = solicitudes;
    }

    
}

