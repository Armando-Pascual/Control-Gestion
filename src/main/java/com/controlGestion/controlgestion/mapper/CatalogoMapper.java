package com.controlGestion.controlgestion.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.controlGestion.controlgestion.dto.Catalogos.AdministracionDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdministradorAdministracionDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdministradorCentralDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdministradorGeneralDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdmonCentralDTO;
import com.controlGestion.controlgestion.dto.Catalogos.AdmonGeneralDTO;
import com.controlGestion.controlgestion.model.AdministracionModel;
import com.controlGestion.controlgestion.model.AdministradorAdministracionModel;
import com.controlGestion.controlgestion.model.AdministradorCentralModel;
import com.controlGestion.controlgestion.model.AdministradorGeneralModel;
import com.controlGestion.controlgestion.model.AdmonCentralModel;
import com.controlGestion.controlgestion.model.AdmonGeneralModel;

public class CatalogoMapper {

    public static AdministradorAdministracionDTO toAdministradorAdministracionDTO(AdministradorAdministracionModel model) {
        AdministradorAdministracionDTO dto = new AdministradorAdministracionDTO();
        dto.setCveIdAdministradorAdministracion(model.getId());
        dto.setCorreo(model.getCorreo());
        dto.setFecRegistroAlta(model.getFecRegistroAlta());
        dto.setFecRegistroBaja(model.getFecRegistroBaja());
        dto.setNombreAdministrador(model.getNombre());
        dto.setPrimerApellidoAdministrador(model.getPrimerApellido());
        dto.setSegundoApellidoAdministrador(model.getSegundoApellido());
        dto.setCveIdAdministracion(model.getAdministracion().getId());
        return dto;
    }

    public static AdministracionDTO toAdministracionDTO(AdministracionModel model) {
        AdministracionDTO dto = new AdministracionDTO();
        dto.setCveIdAdministracion(model.getId());
        dto.setAcronimo(model.getAcronimo());
        dto.setFecRegistroAlta(model.getFecRegistroAlta());
        dto.setFecRegistroBaja(model.getFecRegistroBaja());
        dto.setAdministracion(model.getAdministracion());
        dto.setPuesto(model.getPuesto());
        dto.setCveIdAdmonCentral(model.getAdmonCentral().getId());
        return dto;
    }

    public static AdmonCentralDTO toAdmonCentralDTO(AdmonCentralModel model) {
        AdmonCentralDTO dto = new AdmonCentralDTO();
        dto.setCveIdAdmonCentral(model.getId());
        dto.setAcronimo(model.getAcronimo());
        dto.setFecRegistroAlta(model.getFecRegistroAlta());
        dto.setFecRegistroBaja(model.getFecRegistroBaja());
        dto.setAdministracion(model.getAdministracion());
        return dto;
    }

    public static AdmonGeneralDTO toAdmonGeneralDTO(AdmonGeneralModel model) {
        AdmonGeneralDTO dto = new AdmonGeneralDTO();
        dto.setCveIdAdmonGeneral(model.getId());
        dto.setAcronimo(model.getAcronimo());
        dto.setFecRegistroAlta(model.getFecRegistroAlta());
        dto.setAdministracion(model.getAdministracion());
        dto.setPuesto(model.getPuesto());
        return dto;
    }

    public static AdministradorCentralDTO toAdministradorCentralDTO(AdministradorCentralModel model) {
        AdministradorCentralDTO dto = new AdministradorCentralDTO();
        dto.setCveIdAdministradorCentral(model.getId());
        dto.setFecRegistroAlta(model.getFecRegistroAlta());
        dto.setFecRegistroBaja(model.getFecRegistroBaja());
        dto.setNombreAdministrador(model.getNombre());
        dto.setPrimerApellidoAdministrador(model.getPrimerApellido());
        dto.setSegundoApellidoAdministrador(model.getSegundoApellido());
        dto.setCveIdAdmonCentral(model.getAdmonCentral().getId());
        return dto;
    }

    public static AdministradorGeneralDTO toAdministradorGeneralDTO(AdministradorGeneralModel model) {
        AdministradorGeneralDTO dto = new AdministradorGeneralDTO();
        dto.setCveIdAdministradorGeneral(model.getId());
        dto.setCorreo(model.getCorreo());
        dto.setFecRegistroAlta(model.getFecRegistroAlta());
        dto.setNombreAdministrador(model.getNombre());
        dto.setPrimerApellidoAdministrador(model.getPrimerApellido());
        dto.setSegundoApellidoAdministrador(model.getSegundoApellido());
        dto.setCveIdAdmonGeneral(model.getAdmonGeneral().getId());
        return dto;
    }

    // Métodos para listas
    public static List<AdministradorAdministracionDTO> toAdministradorAdministracionDTOList(List<AdministradorAdministracionModel> models) {
        return models.stream().map(CatalogoMapper::toAdministradorAdministracionDTO).collect(Collectors.toList());
    }

    public static List<AdministracionDTO> toAdministracionDTOList(List<AdministracionModel> models) {
        return models.stream().map(CatalogoMapper::toAdministracionDTO).collect(Collectors.toList());
    }

    public static List<AdmonCentralDTO> toAdmonCentralDTOList(List<AdmonCentralModel> models) {
        return models.stream().map(CatalogoMapper::toAdmonCentralDTO).collect(Collectors.toList());
    }

    public static List<AdmonGeneralDTO> toAdmonGeneralDTOList(List<AdmonGeneralModel> models) {
        return models.stream().map(CatalogoMapper::toAdmonGeneralDTO).collect(Collectors.toList());
    }

    public static List<AdministradorCentralDTO> toAdministradorCentralDTOList(List<AdministradorCentralModel> models) {
        return models.stream().map(CatalogoMapper::toAdministradorCentralDTO).collect(Collectors.toList());
    }

    public static List<AdministradorGeneralDTO> toAdministradorGeneralDTOList(List<AdministradorGeneralModel> models) {
        return models.stream().map(CatalogoMapper::toAdministradorGeneralDTO).collect(Collectors.toList());
    }
}