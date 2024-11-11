package org.itSurvey.survey.answer.answerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestAnswerDTO(
    @NotBlank
    String text,
    @NotNull
    Long questionId
) {} 