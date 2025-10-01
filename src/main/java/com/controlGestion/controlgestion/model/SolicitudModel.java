package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cgt_solicitud", schema = "gestdoc")
public class SolicitudModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cve_id_solicitud")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cve_id_estatus")
    @JsonIgnore
    private EstatusModel estatus;

    @ManyToOne
    @JoinColumn(name = "cve_id_usuario")
    @JsonIgnore
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "cve_id_tipo_documento")
    @JsonIgnore
    private TipoDocumentoModel tipoDocumento;

    @Column(name = "cve_id_tipo_clasificacion")
    private Integer clasificacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cve_id_asignacion")
    @JsonIgnore
    private AsignacionModel asignacion;

    @Column(name = "cve_id_documento")
    private String cveIdDocumento;

    @ManyToOne
    @JoinColumn(name = "cve_id_remitente")
    @JsonIgnore
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

    @Column(name = "fec_registro_alta")
    private LocalDateTime fechaRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fechaBaja;

    @Column(name = "asunto")
    private String asunto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "reasignado")
    private Boolean reasignado;

    @Column(name = "ind_origen")
    private Integer indOrigen;
    
    public Integer getIndOrigen() {
        return indOrigen;
    }   
    public void setIndOrigen(Integer indOrigen) {
        this.indOrigen = indOrigen;
    }   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstatusModel getEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusModel estatus) {
        this.estatus = estatus;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public TipoDocumentoModel getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoModel tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getClasificacion() {
        return clasificacion;
    } 
    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }   

    public AsignacionModel getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(AsignacionModel asignacion) {
        this.asignacion = asignacion;
    }

    

    public RemitenteModel getRemitente() {
        return remitente;
    }

    public void setRemitente(RemitenteModel remitente) {
        this.remitente = remitente;
    }

    public String getNoRequerimiento() {
        return noRequerimiento;
    }

    public void setNoRequerimiento(String noRequerimiento) {
        this.noRequerimiento = noRequerimiento;
    }

    public LocalDateTime getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(LocalDateTime fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public LocalDateTime getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public LocalDateTime getFechaEsperadaEntrega() {
        return fechaEsperadaEntrega;
    }

    public void setFechaEsperadaEntrega(LocalDateTime fechaEsperadaEntrega) {
        this.fechaEsperadaEntrega = fechaEsperadaEntrega;
    }

    public LocalDateTime getFechaActualizacionEstado() {
        return fechaActualizacionEstado;
    }

    public void setFechaActualizacionEstado(LocalDateTime fechaActualizacionEstado) {
        this.fechaActualizacionEstado = fechaActualizacionEstado;
    }

    public LocalDateTime getFechaRegistroAlta() {
        return fechaRegistroAlta;
    }

    public void setFechaRegistroAlta(LocalDateTime fechaRegistroAlta) {
        this.fechaRegistroAlta = fechaRegistroAlta;
    }

    public LocalDateTime getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDateTime fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getReasignado() {
        return reasignado;
    }

    public void setReasignado(Boolean reasignado) {
        this.reasignado = reasignado;
    }

    public SolicitudModel() {
    }
    public String getCveIdDocumento() {
        return cveIdDocumento;
    }
    public void setCveIdDocumento(String cveIdDocumento) {
        this.cveIdDocumento = cveIdDocumento;
    }



}
