package com.controlGestion.controlgestion.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.RemitenteDTO;
import com.controlGestion.controlgestion.dto.SolicitudDTO;
import com.controlGestion.controlgestion.model.EstatusModel;
import com.controlGestion.controlgestion.model.RemitenteModel;
import com.controlGestion.controlgestion.model.SolicitudModel;
import com.controlGestion.controlgestion.model.TipoDocumentoModel;
import com.controlGestion.controlgestion.model.UsuarioModel;
import com.controlGestion.controlgestion.repository.EstatusRepository;
import com.controlGestion.controlgestion.repository.RemitenteRepository;
import com.controlGestion.controlgestion.repository.SolicitudRepository;
import com.controlGestion.controlgestion.repository.TipoDocumentoRepository;
import com.controlGestion.controlgestion.repository.UsuarioRepository;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private EstatusRepository estatusRepository;

    @Autowired
    private RemitenteRepository remitenteRepository;

    public SolicitudModel crearSolicitud(SolicitudDTO dto) {
        // Buscamos las entidades relacionadas
        UsuarioModel usuario = usuarioRepository.findById(dto.getIdUsuario()).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        TipoDocumentoModel tipo = tipoDocumentoRepository.findById(dto.getIdTipoDocumento()).orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado"));

        EstatusModel estatus = estatusRepository.findById(1).orElseThrow(() -> new RuntimeException("Estatus no encontrado"));

        // Cremos y guardaomes el remitente
        RemitenteDTO dtoRemitente = dto.getRemitente();

        RemitenteModel remitente = new RemitenteModel();
        remitente.setNombre(dtoRemitente.getNombre());
        remitente.setPrimerApellido(dtoRemitente.getPrimerApellido());
        remitente.setSegundoApellido(dtoRemitente.getSegundoApellido());
        remitente.setArea(dtoRemitente.getArea());
        remitente.setPuesto(dtoRemitente.getPuesto());

        remitenteRepository.save(remitente);

        // creamos la solicitud
        SolicitudModel solicitud = new SolicitudModel();
        solicitud.setUsuario(usuario);
        solicitud.setTipoDocumento(tipo);
        solicitud.setFechaEsperadaEntrega(dto.getFechaEsperadaEntrega());
        solicitud.setEstatus(estatus);
        solicitud.setRemitente(remitente); // Asignar el remitente creado

        return solicitudRepository.save(solicitud);
    }
}


