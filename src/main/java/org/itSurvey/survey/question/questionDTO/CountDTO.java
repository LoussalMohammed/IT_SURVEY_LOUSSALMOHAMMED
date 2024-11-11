package org.itSurvey.survey.question.questionDTO;


import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;

import java.util.List;

public record CountDTO(
        String question,
        Integer answerCount,
        List<ResponseAnswerDTO> answers
)
{}
