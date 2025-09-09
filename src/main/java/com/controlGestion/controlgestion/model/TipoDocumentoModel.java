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
@Table(name = "cgc_tipo_documento", schema = "gestdoc")
public class TipoDocumentoModel {

    @Id
    @Column(name = "cve_id_tipo_documento")
    private Integer id;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

    @OneToMany(mappedBy = "tipoDocumento")
    private List<SolicitudModel> solicitudes;
}

