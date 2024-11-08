package org.itSurvey.survey.survey.surveyDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.ResponseSurveyEditionDTO;

import java.util.List;

public record ResponseSurveyDTO(
        @NotNull
        Long id,
        @NotBlank
        @Size(min = 6,
                message = "Title Should Contain at Least 6 Letters")
        String title,
        @NotBlank
        @Size(max = 550
                , min = 10, message = "Description Size Should Be Between 100 and 550")
        String description,
        List<ResponseSurveyEditionDTO> surveyEditions
) {
}
