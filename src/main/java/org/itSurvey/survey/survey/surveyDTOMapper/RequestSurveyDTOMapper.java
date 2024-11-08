package org.itSurvey.survey.survey.surveyDTOMapper;

import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.survey.surveyDTO.RequestSurveyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestSurveyDTOMapper {
    Survey toSurvey(RequestSurveyDTO requestSurveyDTO);
    RequestSurveyDTO toRequestSurveyDTO(Survey survey);
}
