package org.itSurvey.survey.surveyEdition.surveyEditionDTOMapper;

import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.RequestSurveyEditionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestSurveyEditionDTOMapper {
    RequestSurveyEditionDTO toRequestSurveyEditionDTO(SurveyEdition surveyEdition);
    SurveyEdition toSurveyEdition(RequestSurveyEditionDTO requestSurveyEditionDTO);
}
