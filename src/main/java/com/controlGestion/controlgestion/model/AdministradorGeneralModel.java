package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cgc_administrador_general", schema = "gestdoc")
public class AdministradorGeneralModel {

    @Id
    @Column(name = "cve_id_administrador_general")
    private Integer id;

    @Column(name = "nombre_administrador", length = 30)
    private String nombre;

    @Column(name = "primer_apellido_administrador", length = 30)
    private String primerApellido;

    @Column(name = "segundo_apellido_administrador", length = 30)
    private String segundoApellido;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "cve_id_admon_general")
    private AdmonGeneralModel admonGeneral;
}

