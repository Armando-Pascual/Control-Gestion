package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;

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
@Table(name = "cgc_administrador_central", schema = "gestdoc")
public class AdministradorCentralModel {

    @Id
    @Column(name = "cve_id_administrador_central")
    private Integer id;

    @Column(name = "nombre_administrador", length = 30)
    private String nombre;

    @Column(name = "primer_apellido_administrador", length = 30)
    private String primerApellido;

    @Column(name = "segundo_apellido_administrador", length = 30)
    private String segundoApellido;

    @ManyToOne
    @JoinColumn(name = "cve_id_admon_central")
    private AdmonCentralModel admonCentral;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;
}
