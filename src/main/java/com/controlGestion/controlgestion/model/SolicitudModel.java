package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cgt_solicitud", schema = "gestdoc")
public class SolicitudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cve_id_solicitud")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cve_id_estatus")
    private EstatusModel estatus;

    @ManyToOne
    @JoinColumn(name = "cve_id_usuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "cve_id_tipo_documento")
    private TipoDocumentoModel tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "cve_id_tipo_clasificacion")
    private ClasificacionModel clasificacion;

    @ManyToOne
    @JoinColumn(name = "cve_id_asignacion")
    private AsignacionModel asignacion;

    @ManyToOne
    @JoinColumn(name = "cve_id_documento")
    private DocumentoSolicitudModel documento;

    @ManyToOne
    @JoinColumn(name = "cve_id_remitente")
    private RemitenteModel remitente;

    @Column(name = "no_requerimiento")
    private String noRequerimiento;

    @Column(name = "fec_documento")
    private LocalDateTime fechaDocumento;

    @Column(name = "fec_recepcion")
    private LocalDateTime fechaRecepcion;

    @Column(name = "fec_esperada_entrega")
    private LocalDateTime fechaEsperadaEntrega;

    @Column(name = "fec_actualizacion_edo")
    private LocalDateTime fechaActualizacionEstado;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fechaBaja;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "reasignado")
    private Boolean reasignado;
}
