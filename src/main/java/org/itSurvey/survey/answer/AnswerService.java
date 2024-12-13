package org.itSurvey.survey.answer;

import org.itSurvey.survey.answer.answerDTO.RequestAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.UpdateAnswerDTO;
import org.itSurvey.survey.shared.dto.PageDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnswerService {
    ResponseAnswerDTO createAnswer(RequestAnswerDTO requestAnswerDTO);
    PageDTO<ResponseAnswerDTO> getAllAnswers(Pageable pageable);
    ResponseAnswerDTO getAnswerById(Long id);
    ResponseAnswerDTO updateAnswerById(UpdateAnswerDTO updateAnswerDTO, Long id);
    void deleteAnswerById(Long id);
    List<ResponseAnswerDTO> getAnswersByQuestionId(Long questionId);
}
