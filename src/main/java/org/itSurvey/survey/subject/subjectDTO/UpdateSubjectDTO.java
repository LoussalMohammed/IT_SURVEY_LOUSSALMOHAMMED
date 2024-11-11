package org.itSurvey.survey.subject.subjectDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateSubjectDTO(
        @NotBlank
        @Size(min = 6,
                message = "Title Should Contain at Least 6 Letters")
        String title,
        Long surveyEditionId,

        Long parentSubjectId
)
{}
