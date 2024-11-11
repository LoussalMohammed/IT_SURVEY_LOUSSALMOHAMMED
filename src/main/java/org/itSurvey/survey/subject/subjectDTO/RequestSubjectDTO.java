package org.itSurvey.survey.subject.subjectDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.itSurvey.survey.question.questionDTO.RequestQuestionDTO;

public record RequestSubjectDTO(
        @NotBlank
        @Size(min = 6,
                message = "Title Should Contain at Least 6 Letters")
        String title,
        @NotNull
        Long surveyEditionId,

        Long parentSubjectId,
        List<RequestQuestionDTO> questions
)
{}
