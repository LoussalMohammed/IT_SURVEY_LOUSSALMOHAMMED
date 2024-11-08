package org.itSurvey.survey.owner.ownerDTOMapper;

import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.owner.ownerDTO.RequestOwnerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestOwnerDTOMapper {
    RequestOwnerDTO toRequestOwnerDTO(Owner owner);
    Owner toOwner(RequestOwnerDTO requestOwnerDTO);
}
