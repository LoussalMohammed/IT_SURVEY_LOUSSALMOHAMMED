package org.itSurvey.survey.surveyEdition;


import org.itSurvey.survey.surveyEdition.surveyEditionDTO.RequestSurveyEditionDTO;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.ResponseSurveyEditionDTO;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.UpdateSurveyEditionDTO;

import java.util.List;

public interface SurveyEditionService {
    ResponseSurveyEditionDTO createSurveyEdition(RequestSurveyEditionDTO requestSurveyEditionDTO);
    List<ResponseSurveyEditionDTO> getAllSurveyEditions();
    ResponseSurveyEditionDTO updateSurveyEditionById(UpdateSurveyEditionDTO updateSurveyEditionDTO, Long id);
    ResponseSurveyEditionDTO findSurveyEditionById(Long id);
    ResponseSurveyEditionDTO deleteById(Long id);
}
