package org.itSurvey.survey.subject.subjectDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.question.questionDTO.ResponseQuestionDTO;

import java.util.List;

public record ResponseSubjectDTO(

        @NotNull
        Long id,
        @NotBlank
        @Size(min = 6,
                message = "Title Should Contain at Least 6 Letters")
        String title,
        List<ResponseSubjectDTO> subSubjects,
        List<ResponseQuestionDTO> questions
)
{}
