package org.itSurvey.survey.surveyEdition.surveyEditionDTOMapper;

import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.ResponseSurveyEditionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseSurveyEditionDTOMapper {
    ResponseSurveyEditionDTO toResponseSurveyEditionDTO(SurveyEdition surveyEdition);
    SurveyEdition toSurveyEdition(ResponseSurveyEditionDTO responseSurveyEditionDTO);
}
