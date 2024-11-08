package org.itSurvey.survey.owner.ownerDTOMapper;

import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.owner.ownerDTO.ResponseOwnerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponseOwnerDTOMapper {
    ResponseOwnerDTO toResponseOwnerDTO(Owner owner);
    Owner toOwner(ResponseOwnerDTO responseOwnerDTO);
}
