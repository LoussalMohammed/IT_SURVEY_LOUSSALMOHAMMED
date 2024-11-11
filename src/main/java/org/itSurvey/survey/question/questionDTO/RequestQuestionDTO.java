package org.itSurvey.survey.question.questionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.itSurvey.survey.utils.enums.QuestionType;

public record RequestQuestionDTO(
    @NotBlank
    String text,
    @NotNull
    QuestionType questionType,
    @NotNull
    Long subjectId
) {} 