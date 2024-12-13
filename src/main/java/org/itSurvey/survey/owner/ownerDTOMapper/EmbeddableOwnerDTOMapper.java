package org.itSurvey.survey.owner.ownerDTOMapper;

import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.owner.ownerDTO.EmbeddableOwnerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmbeddableOwnerDTOMapper {
    EmbeddableOwnerDTO toEmbeddableOwnerDTO(Owner owner);
    Owner toOwner(EmbeddableOwnerDTO embeddableOwnerDTO);
}
