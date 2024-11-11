package org.itSurvey.survey.subject.subjectDTOMapper;

import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.subject.subjectDTO.UpdateSubjectDTO;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UpdateSubjectDTOMapper {
    UpdateSubjectDTO toUpdateSubjectDTO(Subject subject);
    Subject toSubject(UpdateSubjectDTO updateSubjectDTO);
}
