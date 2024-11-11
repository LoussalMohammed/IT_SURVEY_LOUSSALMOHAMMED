package org.itSurvey.survey.answer;

import org.itSurvey.survey.answer.answerDTO.RequestAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.UpdateAnswerDTO;

import java.util.List;

public interface AnswerService {
    ResponseAnswerDTO createAnswer(RequestAnswerDTO requestAnswerDTO);
    List<ResponseAnswerDTO> getAllAnswers();
    ResponseAnswerDTO getAnswerById(Long id);
    ResponseAnswerDTO updateAnswerById(UpdateAnswerDTO updateAnswerDTO, Long id);
    void deleteAnswerById(Long id);
    List<ResponseAnswerDTO> getAnswersByQuestionId(Long questionId);
}
