package org.itSurvey.survey.surveyEdition.surveyEditionDTOMapper;

import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.survey.surveyDTO.UpdateSurveyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateSurveyEditionDTOMapper {
    UpdateSurveyDTO toUpdateSurveyDTO(SurveyEdition surveyEdition);
    SurveyEdition toSurveyEdition(UpdateSurveyDTO updateSurveyDTO);
}
