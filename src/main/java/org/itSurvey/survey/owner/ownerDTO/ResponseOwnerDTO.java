package org.itSurvey.survey.owner.ownerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.survey.surveyDTO.ResponseSurveyDTO;

import java.util.List;

public record ResponseOwnerDTO(
        @NotNull
        Long id,
        @NotBlank
        @Size(min = 3,
                message = "Name Should Contain At Least 3 Letters")
        String name,
        List<ResponseSurveyDTO> surveys
)
{}
