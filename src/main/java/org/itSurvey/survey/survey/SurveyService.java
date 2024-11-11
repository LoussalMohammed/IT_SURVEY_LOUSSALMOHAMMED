package org.itSurvey.survey.survey;

import org.itSurvey.survey.survey.surveyDTO.RequestSurveyDTO;
import org.itSurvey.survey.survey.surveyDTO.ResponseSurveyDTO;
import org.itSurvey.survey.survey.surveyDTO.UpdateSurveyDTO;

import java.util.List;

public interface SurveyService {
    ResponseSurveyDTO createSurvey(RequestSurveyDTO requestSurveyDTO);
    List<ResponseSurveyDTO> getAllSurveys();
    ResponseSurveyDTO updateSurveyById(UpdateSurveyDTO updateSurveyDTO, Long id);
    ResponseSurveyDTO findSurveyById(Long id);
    ResponseSurveyDTO deleteById(Long id);
    ResponseSurveyDTO results(Long id);
}
