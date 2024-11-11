package org.itSurvey.survey.answer.answerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ResponseAnswerDTO(
    @NotNull
    Long id,
    @NotBlank
    String text,
    Integer selectionCount
) {} 