package org.itSurvey.survey.answer.answerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.itSurvey.survey.question.questionDTO.EmbeddableQuestionDTO;

public record ResponseAnswerDTO(
    EmbeddableQuestionDTO question,
    @NotNull
    Long id,
    @NotBlank
    String text,
    Integer selectionCount
) {} 