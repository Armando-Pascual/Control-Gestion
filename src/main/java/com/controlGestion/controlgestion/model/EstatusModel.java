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
@Table(name = "cgc_estatus", schema = "gestdoc")
public class EstatusModel {

    @Id
    @Column(name = "cve_id_estatus")
    private Integer id;

    @Column(name = "ref_estado")
    private String refEstado;

    @Column(name = "desc_estado")
    private String descEstado;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

    @Column(name = "fec_actualizacion")
    private LocalDateTime fecActualizacion;

    @OneToMany(mappedBy = "estatus")
    private List<SolicitudModel> solicitudes;
}



