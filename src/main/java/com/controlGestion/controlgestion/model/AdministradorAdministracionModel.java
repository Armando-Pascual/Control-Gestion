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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cgc_administrador_administracion", schema = "gestdoc")
public class AdministradorAdministracionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cve_id_administrador_administracion")
    private Integer id;

    @Column(name = "nombre_administrador", length = 30)
    private String nombre;

    @Column(name = "primer_apellido_administrador", length = 30)
    private String primerApellido;

    @Column(name = "segundo_apellido_administrador", length = 30)
    private String segundoApellido;

    @Column(name = "correo", length = 30)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "cve_id_administracion")
    private AdministracionModel administracion;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

    @OneToMany(mappedBy = "administradorAdministracion")
    @JsonIgnore
    private List<AsignacionModel> asignaciones;
}
