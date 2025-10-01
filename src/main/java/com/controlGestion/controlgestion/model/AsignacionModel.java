package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cgt_asignacion", schema = "gestdoc")
public class AsignacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cve_id_asignacion")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cve_id_administrador_administracion")
    private AdministradorAdministracionModel administradorAdministracion;

    @Column(name = "fec_asignacion")
    private LocalDateTime fecAsignacion;

    @Column(name = "nombre_asignado")
    private String nombreAsignado;

    @Column(name = "primer_apellido_asignado")
    private String primerApellidoAsignado;

    @Column(name = "segundo_apellido_asignado")
    private String segundoApellidoAsignado;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

    @OneToMany(mappedBy = "asignacion")
    @JsonIgnore
    private List<SolicitudModel> solicitudes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdministradorAdministracionModel getAdministradorAdministracion() {
        return administradorAdministracion;
    }

    public void setAdministradorAdministracion(AdministradorAdministracionModel administradorAdministracion) {
        this.administradorAdministracion = administradorAdministracion;
    }

    public LocalDateTime getFecAsignacion() {
        return fecAsignacion;
    }

    public void setFecAsignacion(LocalDateTime fecAsignacion) {
        this.fecAsignacion = fecAsignacion;
    }

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
