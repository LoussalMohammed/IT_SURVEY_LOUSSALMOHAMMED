package org.itSurvey.survey.owner.ownerDTOMapper;

import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.owner.ownerDTO.UpdateOwnerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateOwnerDTOMapper {
    UpdateOwnerDTO toUpdateOwnerDTO(Owner owner);
    Owner toOwner(UpdateOwnerDTO updateOwnerDTO);
}
