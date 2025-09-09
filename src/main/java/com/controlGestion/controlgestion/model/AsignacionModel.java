package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cgt_asignacion", schema = "gestdoc")
public class AsignacionModel {

    @Id
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
    private List<SolicitudModel> solicitudes;
}
