package org.itSurvey.survey.owner.ownerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestOwnerDTO(
        @NotBlank
        @Size(min = 3,
        message = "Name Should Contain At Least 3 Letters")
        String name
)
{}
