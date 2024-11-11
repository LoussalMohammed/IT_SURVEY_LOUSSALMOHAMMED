package org.itSurvey.survey.subject.subjectDTOMapper;

import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.subject.subjectDTO.RequestSubjectDTO;
import org.itSurvey.survey.question.questionDTOMapper.RequestQuestionDTOMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RequestQuestionDTOMapper.class})
public interface RequestSubjectDTOMapper {
    @Mapping(target = "surveyEdition", ignore = true)
    @Mapping(target = "parentSubject", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    Subject toSubject(RequestSubjectDTO requestSubjectDTO);
    
    RequestSubjectDTO toRequestSubjectDTO(Subject subject);
}
