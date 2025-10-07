package com.controlGestion.controlgestion.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controlGestion.controlgestion.dto.AsignacionDTO;
import com.controlGestion.controlgestion.dto.RemitenteDTO;
import com.controlGestion.controlgestion.dto.SolicitudDTO;
import com.controlGestion.controlgestion.model.AsignacionModel;
import com.controlGestion.controlgestion.model.EstatusModel;
import com.controlGestion.controlgestion.model.RemitenteModel;
import com.controlGestion.controlgestion.model.SolicitudModel;
import com.controlGestion.controlgestion.model.TipoDocumentoModel;
import com.controlGestion.controlgestion.model.UsuarioModel;
import com.controlGestion.controlgestion.model.Enum.EstatusEnum;
import com.controlGestion.controlgestion.repository.AdministradorAdministracionRepository;
import com.controlGestion.controlgestion.repository.AsignacionRepository;
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

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private AdministradorAdministracionRepository administradorAdministracionRepository;

    


    private static final Logger logger = LoggerFactory.getLogger(SolicitudService.class);

    public SolicitudModel crearSolicitud(SolicitudDTO dto) {
        // Buscamos las entidades relacionadas
        if (dto.getIdUsuario() == null)
            throw new IllegalArgumentException("idUsuario no puede ser nulo");
        logger.info("Creando solicitud para el usuario ID: " + dto.getIdUsuario());
        if (dto.getIdTipoDocumento() == null)
            throw new IllegalArgumentException("idTipoDocumento no puede ser nulo");
        logger.info("Creando solicitud para el usuario ID: " + dto.getIdUsuario() + " con tipo de documento ID: "
                + dto.getIdTipoDocumento());

        UsuarioModel usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        TipoDocumentoModel tipo = tipoDocumentoRepository.findById(dto.getIdTipoDocumento())
                .orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado"));

        // creamos y guardamos el asignado
        AsignacionDTO dtoAsignacion = dto.getAsignacion();

        AsignacionModel asignado = new AsignacionModel();
        asignado.setNombreAsignado(dtoAsignacion.getNombreAsignado());
        asignado.setPrimerApellidoAsignado(dtoAsignacion.getPrimerApellidoAsignado());
        asignado.setSegundoApellidoAsignado(dtoAsignacion.getSegundoApellidoAsignado());
        asignado.setFecAsignacion(dtoAsignacion.getFecAsignacion());
        asignado.setFecRegistroAlta(dtoAsignacion.getFecRegistroAlta());
        asignado.setFecRegistroBaja(dtoAsignacion.getFecRegistroBaja());
        asignado.setAdministradorAdministracion(
                dtoAsignacion.getCveIdAdministradorAdministracion() != null
                        ? administradorAdministracionRepository
                                .findById(dtoAsignacion.getCveIdAdministradorAdministracion())
                                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"))
                        : null);

        asignacionRepository.save(asignado);

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
        solicitud.setAsignacion(asignado); // Asocia la asignación creada
        solicitud.setClasificacion(dto.getIdTipoClasificacion());
        solicitud.setFechaEsperadaEntrega(dto.getFechaEsperadaEntrega());
        solicitud.setAsunto(dto.getAsunto());
        solicitud.setDescripcion(dto.getDescripcion());
        solicitud.setFechaRegistroAlta(dto.getFechaRegistroAlta());
        solicitud.setFechaBaja(dto.getFechaRegistroBaja());
        solicitud.setNoRequerimiento(dto.getNoRequerimiento());
        solicitud.setFechaRecepcion(dto.getFechaRecepcion());
        solicitud.setFechaDocumento(dto.getFecDocumento());
        solicitud.setFechaActualizacionEstado(dto.getFecActualizacionEdo());
        solicitud.setEstatus(estatusRepository.findById(
                dto.getEstatusId() != null ? dto.getEstatusId() : EstatusEnum.ASIGNADA.getId())
                .orElseThrow(() -> new RuntimeException("Estatus no encontrado")));

        solicitud.setRemitente(remitente); // Asignar el remitente creado
        solicitud.setFechaActualizacionEstado(java.time.LocalDateTime.now());
        solicitud.setIndOrigen(1); // Indica que la solicitud fue creada desde Recepción
        return solicitudRepository.save(solicitud);
    }

    public SolicitudModel actualizarEstatus(Integer idSolicitud, EstatusEnum nuevoEstatus) {
        logger.info("Actualizando estatus de la solicitud ID: " + idSolicitud + " al nuevo estatus: "
                + nuevoEstatus.name());

        // Buscar la solicitud
        SolicitudModel solicitud = solicitudRepository.findById(idSolicitud)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        // Obtener el estatus actual
        Integer estadoActualId = solicitud.getEstatus().getId();
        logger.info("Estatus actual de la solicitud ID: " + idSolicitud + " es: " + estadoActualId);

        // Validaciones de transición
        if (nuevoEstatus == EstatusEnum.PROCESO_DE_ENTREGA && estadoActualId != EstatusEnum.REVISION.getId()) {
            throw new IllegalStateException("Solo se puede pasar a EN PROCESO ENTREGA desde REVISION");
        }

        if (nuevoEstatus == EstatusEnum.ATENDIDA && estadoActualId != EstatusEnum.DOCUMENTO_ACUSE.getId()) {
            throw new IllegalStateException("Solo se puede pasar a ATENDIDA desde DOCUMENTO DE ACUSE");
        }

        // Obtener el nuevo estatus desde la base de datos
        EstatusModel estatusModel = estatusRepository.findById(nuevoEstatus.getId())
                .orElseThrow(() -> new RuntimeException("Estatus no encontrado"));

        // Actualizar la solicitud
        solicitud.setEstatus(estatusModel);
        solicitud.setFechaActualizacionEstado(LocalDateTime.now());

        return solicitudRepository.save(solicitud);
    }

    public SolicitudModel obtenerPorId(Integer idSolicitud) {
        return solicitudRepository.findById(idSolicitud)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    public List<SolicitudModel> obtenerTodas() {
        return solicitudRepository.findAll();
    }

    public SolicitudModel actualizarFechaBaja(Integer idSolicitud, LocalDateTime fechaBaja) {
        if (fechaBaja == null) {
            throw new IllegalArgumentException("La fecha de baja no puede ser nula");
        }
        SolicitudModel solicitud = solicitudRepository.findById(idSolicitud)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        solicitud.setFechaBaja(fechaBaja);
        return solicitudRepository.save(solicitud);
    }

    public SolicitudModel crearSolicitudAsignacion(SolicitudDTO dto) {
        // Buscamos las entidades relacionadas
        if (dto.getIdUsuario() == null)
            throw new IllegalArgumentException("idUsuario no puede ser nulo");
        logger.info("Creando solicitud para el usuario ID: " + dto.getIdUsuario());
        if (dto.getIdTipoDocumento() == null)
            throw new IllegalArgumentException("idTipoDocumento no puede ser nulo");
        logger.info("Creando solicitud para el usuario ID: " + dto.getIdUsuario() + " con tipo de documento ID: "
                + dto.getIdTipoDocumento());

        UsuarioModel usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        TipoDocumentoModel tipo = tipoDocumentoRepository.findById(dto.getIdTipoDocumento())
                .orElseThrow(() -> new RuntimeException("Tipo de documento no encontrado"));

        // creamos y guardamos el asignado
        AsignacionDTO dtoAsignacion = dto.getAsignacion();

        AsignacionModel asignado = new AsignacionModel();
        asignado.setNombreAsignado(dtoAsignacion.getNombreAsignado());
        asignado.setPrimerApellidoAsignado(dtoAsignacion.getPrimerApellidoAsignado());
        asignado.setSegundoApellidoAsignado(dtoAsignacion.getSegundoApellidoAsignado());
        asignado.setFecAsignacion(dtoAsignacion.getFecAsignacion());
        asignado.setFecRegistroAlta(dtoAsignacion.getFecRegistroAlta());
        asignado.setFecRegistroBaja(dtoAsignacion.getFecRegistroBaja());
        asignado.setAdministradorAdministracion(
                dtoAsignacion.getCveIdAdministradorAdministracion() != null
                        ? administradorAdministracionRepository
                                .findById(dtoAsignacion.getCveIdAdministradorAdministracion())
                                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"))
                        : null);

        asignacionRepository.save(asignado);

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
        solicitud.setAsignacion(asignado); // Asocia la asignación creada
        solicitud.setClasificacion(dto.getIdTipoClasificacion());
        solicitud.setFechaEsperadaEntrega(dto.getFechaEsperadaEntrega());
        solicitud.setAsunto(dto.getAsunto());
        solicitud.setDescripcion(dto.getDescripcion());
        solicitud.setFechaRegistroAlta(dto.getFechaRegistroAlta());
        solicitud.setFechaBaja(dto.getFechaRegistroBaja());
        solicitud.setNoRequerimiento(dto.getNoRequerimiento());
        solicitud.setFechaRecepcion(dto.getFechaRecepcion());
        solicitud.setFechaDocumento(dto.getFecDocumento());
        solicitud.setFechaActualizacionEstado(dto.getFecActualizacionEdo());
        solicitud.setEstatus(estatusRepository.findById(
                dto.getEstatusId() != null ? dto.getEstatusId() : EstatusEnum.ASIGNADA.getId())
                .orElseThrow(() -> new RuntimeException("Estatus no encontrado")));

        solicitud.setRemitente(remitente); // Asignar el remitente creado
        solicitud.setFechaActualizacionEstado(java.time.LocalDateTime.now());
        solicitud.setIndOrigen(2); // Indica que la solicitud fue creada desde Asignación
        return solicitudRepository.save(solicitud);
    }

    public SolicitudModel actualizarEstatusYDocumento(Integer idSolicitud, EstatusEnum nuevoEstatus,String cveIdDocumento, String comentarios, Boolean reasignado) {
        logger.info("Actualizando estatus de la solicitud ID: " + idSolicitud + " al nuevo estatus: "
                + nuevoEstatus.name());

        SolicitudModel solicitud = solicitudRepository.findById(idSolicitud)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        Integer estadoActualId = solicitud.getEstatus().getId();
        logger.info("Estatus actual de la solicitud ID: " + idSolicitud + " es: " + estadoActualId);

        if (nuevoEstatus == EstatusEnum.PROCESO_DE_ENTREGA && estadoActualId != EstatusEnum.REVISION.getId()) {
            throw new IllegalStateException("Solo se puede pasar a EN PROCESO ENTREGA desde REVISION");
        }

        if (nuevoEstatus == EstatusEnum.ATENDIDA && estadoActualId != EstatusEnum.DOCUMENTO_ACUSE.getId()) {
            throw new IllegalStateException("Solo se puede pasar a ATENDIDA desde DOCUMENTO DE ACUSE");
        }

        EstatusModel estatusModel = estatusRepository.findById(nuevoEstatus.getId())
                .orElseThrow(() -> new RuntimeException("Estatus no encontrado"));

        // Aquí simplemente se asigna el valor recibido
        solicitud.setEstatus(estatusModel);
        if(solicitud.getCveIdDocumento()==null || solicitud.getCveIdDocumento().isEmpty()){
              solicitud.setCveIdDocumento(cveIdDocumento);
        }
        //solicitud.setCveIdDocumento(cveIdDocumento);
        solicitud.setComentarios(comentarios);
        solicitud.setReasignado(reasignado);

        return solicitudRepository.save(solicitud);
    }

}