package org.itSurvey.survey.survey.surveyDTOMapper;

import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.survey.surveyDTO.UpdateSurveyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateSurveyDTOMapper {
    Survey toSurvey(UpdateSurveyDTO updateSurveyDTO);
    UpdateSurveyDTO toUpdateSurveyDTO(Survey survey);
}
