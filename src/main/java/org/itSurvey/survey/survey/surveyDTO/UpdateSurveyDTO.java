package org.itSurvey.survey.survey.surveyDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.owner.Owner;

public record UpdateSurveyDTO(
        @NotBlank
        @Size(min = 6,
                message = "Title Should Contain at Least 6 Letters")
        String title,
        @NotBlank
        @Size(max = 550
                , min = 10, message = "Description Size Should Be Between 100 and 550")
        String description,
        Long ownerId
) {
}
