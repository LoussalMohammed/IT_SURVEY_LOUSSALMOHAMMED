package org.itSurvey.survey.question.questionDTO;

import jakarta.validation.constraints.NotBlank;
import org.itSurvey.survey.utils.enums.QuestionType;

public record UpdateQuestionDTO(
        @NotBlank
        String text,
        QuestionType questionType,
        Long subjectId
) {} 