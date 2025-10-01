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
@Table(name = "cgt_documento_solicitud", schema = "gestdoc")
public class DocumentoSolicitudModel {

    @Id
    @Column(name = "cve_id_documento")
    private Integer id;

    @Column(name = "nombre_oficio")
    private String nombreOficio;

    @Column(name = "path_oficio")
    private String pathOficio;

    @Column(name = "nombre_anexo")
    private String nombreAnexo;

    @Column(name = "path_anexo")
    private String pathAnexo;

    @Column(name = "cargado")
    private Boolean cargado;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

}
