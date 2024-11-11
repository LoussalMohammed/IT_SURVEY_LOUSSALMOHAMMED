package org.itSurvey.survey.owner.ownerDTOMapper;

import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.owner.ownerDTO.ResponseOwnerDTO;
import org.itSurvey.survey.subject.subjectDTOMapper.ResponseSubjectDTOMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ResponseSubjectDTOMapper.class})
public interface ResponseOwnerDTOMapper {
    ResponseOwnerDTO toResponseOwnerDTO(Owner owner);
    Owner toOwner(ResponseOwnerDTO responseOwnerDTO);
}
