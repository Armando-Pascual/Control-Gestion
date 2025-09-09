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
}

