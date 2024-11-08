package org.itSurvey.survey.surveyEdition.surveyEditionDTO;

import jakarta.persistence.*;

import java.time.LocalDate;

public record UpdateSurveyEditionDTO(
        @Temporal(TemporalType.DATE)
        @Column(name = "creation_date")
        LocalDate creationDate,

        @Temporal(TemporalType.DATE)
        @Column(name = "start_date")
        LocalDate startDate,

        @Column(name = "year")
        int year,
        Long surveyId
)
{}
