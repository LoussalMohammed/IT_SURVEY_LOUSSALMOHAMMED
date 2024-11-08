package org.itSurvey.survey.owner.ownerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.survey.Survey;

import java.util.List;

public record UpdateOwnerDTO(
        @NotBlank
        @Size(min = 3,
                message = "Name Should Contain At Least 3 Letters")
        String name,
        List<Survey> surveys
)
{}
