package org.itSurvey.survey.question.questionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;
import org.itSurvey.survey.shared.dto.PageDTO;
import org.itSurvey.survey.subject.subjectDTO.EmbeddableSubjectDTO;
import org.itSurvey.survey.subject.subjectDTO.ResponseSubjectDTO;
import org.itSurvey.survey.utils.enums.QuestionType;

import java.util.List;

public record ResponseQuestionDTO(
    EmbeddableSubjectDTO subject,
    @NotNull
    Long id,
    @NotBlank
    String text,
    Integer answerCount,
    @NotNull
    QuestionType questionType,
    List<ResponseAnswerDTO> answers
) {} 