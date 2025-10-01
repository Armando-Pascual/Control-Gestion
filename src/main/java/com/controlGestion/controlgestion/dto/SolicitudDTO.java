package com.controlGestion.controlgestion.dto;

import java.time.LocalDateTime;


public class SolicitudDTO {
    private Integer idSolicitud;
    private Integer idUsuario;
    private Integer idTipoDocumento;
    private LocalDateTime FechaEsperadaEntrega;
    private String asunto;
    private String descripcion;
    private LocalDateTime fechaRegistroAlta;
    private LocalDateTime fechaRegistroBaja;
    private String cveIdDocumento;
    private Integer idTipoClasificacion;
    private Integer estatusId;
    private Integer indOrigen;
    private String noRequerimiento;
    private LocalDateTime fechaRecepcion;
    private LocalDateTime fecDocumento;
    private LocalDateTime fecActualizacionEdo;
    private String comentarios;
    
    //datos del remitente
    private RemitenteDTO remitente;  
    private AsignacionDTO asignacion;


    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }
    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
    public LocalDateTime getFechaEsperadaEntrega() {
        return FechaEsperadaEntrega;
    }
    public void setFechaEsperadaEntrega(LocalDateTime fechaEsperadaEntrega) {
        FechaEsperadaEntrega = fechaEsperadaEntrega;
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
    public LocalDateTime getFechaRegistroAlta() {
        return fechaRegistroAlta;
    }
    public void setFechaRegistroAlta(LocalDateTime fechaRegistroAlta) {
        this.fechaRegistroAlta = fechaRegistroAlta;
    }
    public LocalDateTime getFechaRegistroBaja() {
        return fechaRegistroBaja;
    }
    public void setFechaRegistroBaja(LocalDateTime fechaRegistroBaja) {
        this.fechaRegistroBaja = fechaRegistroBaja;
    }

    public String getCveIdDocumento() {
        return cveIdDocumento;
    }
    public void setCveIdDocumento(String cveIdDocumento) {
        this.cveIdDocumento = cveIdDocumento;
    }

    public Integer getIdTipoClasificacion() {
        return idTipoClasificacion;
    }
    public void setIdTipoClasificacion(Integer idTipoClasificacion) {
        this.idTipoClasificacion = idTipoClasificacion;
    }
    public String getNoRequerimiento() {
        return noRequerimiento;
    }
    public void setNoRequerimiento(String noRequerimiento) {
        this.noRequerimiento = noRequerimiento;
    }
    public LocalDateTime getFechaRecepcion() {
        return fechaRecepcion;
    }
    public void setFechaRecepcion(LocalDateTime fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
    public LocalDateTime getFecDocumento() {
        return fecDocumento;
    }
    public void setFecDocumento(LocalDateTime fecDocumento) {
        this.fecDocumento = fecDocumento;
    }
    public LocalDateTime getFecActualizacionEdo() {
        return fecActualizacionEdo;
    }
    public void setFecActualizacionEdo(LocalDateTime fecActualizacionEdo) {
        this.fecActualizacionEdo = fecActualizacionEdo;
    }
    public RemitenteDTO getRemitente() {
        return remitente;
    }
    public void setRemitente(RemitenteDTO remitente) {
        this.remitente = remitente;
    }
    public AsignacionDTO getAsignacion() {
        return asignacion;
    }
    public void setAsignacion(AsignacionDTO asignacion) {
        this.asignacion = asignacion;
    }
    public Integer getEstatusId() {
        return estatusId;
    }
    public void setEstatusId(Integer estatusId) {
        this.estatusId = estatusId;
    }
    public Integer getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Integer getIndOrigen() {
        return indOrigen;
    }   
    public void setIndOrigen(Integer indOrigen) {
        this.indOrigen = indOrigen;
    }

    public String getComentarios() {
        return comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
