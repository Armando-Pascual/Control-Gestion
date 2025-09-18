package com.controlGestion.controlgestion.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SolicitudDTO {
    private Integer idUsuario;
    private Integer idTipoDocumento;
    private LocalDateTime FechaEsperadaEntrega;

    //datos del remitente
    private RemitenteDTO remitente;

}
