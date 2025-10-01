package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cgc_clasificacion", schema = "gestdoc")
public class ClasificacionModel {

    @Id
    @Column(name = "cve_id_tipo_clasificacion")
    private Integer id;

    @Column(name = "desc_clasificacion", length = 40)
    private String descripcion;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fechaRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fechaRegistroBaja;

    @OneToMany(mappedBy = "clasificacion")
    private List<SolicitudModel> solicitudes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaRegistroAlta() {
        return fechaRegistroAlta;
    }

    public void setFechaRegistroAlta(LocalDateTime fechaRegistroAlta) {
        this.fechaRegistroAlta = fechaRegistroAlta;
    }

    public LocalDateTime getFechaRegistroBaja() {
        return fechaRegistroBaja;
    }

    public void setFechaRegistroBaja(LocalDateTime fechaRegistroBaja) {
        this.fechaRegistroBaja = fechaRegistroBaja;
    }

    public List<SolicitudModel> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<SolicitudModel> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ClasificacionModel() {
    }

    
}

