package org.itSurvey.survey.surveyEdition.surveyEditionDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ResponseSurveyEditionDTO(
        @Temporal(TemporalType.DATE)
        @Column(name = "creation_date")
        LocalDate creationDate,

        @Temporal(TemporalType.DATE)
        @Column(name = "start_date")
        LocalDate startDate,

        @NotNull
        @Column(name = "year")
        int year
)
{}
