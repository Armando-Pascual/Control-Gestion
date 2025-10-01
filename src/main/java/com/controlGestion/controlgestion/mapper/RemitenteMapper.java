package com.controlGestion.controlgestion.mapper;

import org.mapstruct.Mapper;

import com.controlGestion.controlgestion.dto.RemitenteDTO;
import com.controlGestion.controlgestion.model.RemitenteModel;

@Mapper(componentModel = "spring")
public interface RemitenteMapper {
    RemitenteDTO toDTO(RemitenteModel model);
    RemitenteModel toEntity(RemitenteDTO dto);
}
