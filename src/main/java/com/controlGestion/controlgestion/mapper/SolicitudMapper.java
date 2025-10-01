package com.controlGestion.controlgestion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.controlGestion.controlgestion.dto.SolicitudDTO;
import com.controlGestion.controlgestion.model.SolicitudModel;

@Mapper(componentModel = "spring", uses = { RemitenteMapper.class })
public interface SolicitudMapper {

    SolicitudDTO toDTO(SolicitudModel model);
    SolicitudModel toEntity(SolicitudDTO dto);

    @Mapping(target = "id", ignore = true) // útil para actualizaciones sin sobrescribir el ID
    void updateSolicitudFromDTO(SolicitudDTO dto, @MappingTarget SolicitudModel model);

}

