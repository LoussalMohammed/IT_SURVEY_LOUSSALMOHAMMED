package org.itSurvey.survey.answer.answerDTO;

import jakarta.validation.constraints.NotBlank;

public record UpdateAnswerDTO(
        @NotBlank
        String text,
        Long questionId
) {} 