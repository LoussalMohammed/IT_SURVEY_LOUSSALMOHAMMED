package org.itSurvey.survey.question.questionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.itSurvey.survey.subject.subjectDTO.EmbeddableSubjectDTO;
import org.itSurvey.survey.utils.enums.QuestionType;

public record EmbeddableQuestionDTO(
        @NotBlank
        String text,
        Integer answerCount,
        @NotNull
        QuestionType questionType
)
{}
