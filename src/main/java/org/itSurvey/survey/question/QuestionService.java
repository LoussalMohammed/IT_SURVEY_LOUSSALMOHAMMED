package org.itSurvey.survey.question;


import org.itSurvey.survey.question.questionDTO.CountDTO;
import org.itSurvey.survey.question.questionDTO.RequestQuestionDTO;
import org.itSurvey.survey.question.questionDTO.ResponseQuestionDTO;
import org.itSurvey.survey.question.questionDTO.UpdateQuestionDTO;
import org.itSurvey.survey.shared.dto.PageDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    ResponseQuestionDTO createQuestion(RequestQuestionDTO requestQuestionDTO);
    PageDTO<ResponseQuestionDTO> getAllQuestions(Pageable pageable);
    ResponseQuestionDTO getQuestionById(Long id);
    ResponseQuestionDTO updateQuestionById(UpdateQuestionDTO updateQuestionDTO, Long id);
    void deleteQuestionById(Long id);
    List<ResponseQuestionDTO> getQuestionsBySubjectId(Long subjectId);
    CountDTO answerQuestionById(Long questionId, List<Long> answersIds);
}