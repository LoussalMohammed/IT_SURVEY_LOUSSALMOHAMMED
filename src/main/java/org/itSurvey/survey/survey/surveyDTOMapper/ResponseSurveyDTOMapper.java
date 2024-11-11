package org.itSurvey.survey.survey.surveyDTOMapper;

import org.itSurvey.survey.subject.subjectDTOMapper.ResponseSubjectDTOMapper;
import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.survey.surveyDTO.ResponseSurveyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ResponseSubjectDTOMapper.class})
public interface ResponseSurveyDTOMapper {
    Survey toSurvey(ResponseSurveyDTO responseSurveyDTO);
    ResponseSurveyDTO toResponseSurveyDTO(Survey survey);
}
