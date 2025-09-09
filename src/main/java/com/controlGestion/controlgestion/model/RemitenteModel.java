package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "cgt_remitente", schema = "gestdoc")
public class RemitenteModel {

    @Id
    @Column(name = "cve_id_remitente")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "area")
    private String area;

    @Column(name = "puesto")
    private String puesto;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

    @OneToMany(mappedBy = "remitente")
    private List<SolicitudModel> solicitudes;
}
