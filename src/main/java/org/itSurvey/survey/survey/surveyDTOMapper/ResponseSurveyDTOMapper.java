package org.itSurvey.survey.survey.surveyDTOMapper;

import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.survey.surveyDTO.ResponseSurveyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponseSurveyDTOMapper {
    Survey toSurvey(ResponseSurveyDTO responseSurveyDTO);
    ResponseSurveyDTO toResponseSurveyDTO(Survey survey);
}
