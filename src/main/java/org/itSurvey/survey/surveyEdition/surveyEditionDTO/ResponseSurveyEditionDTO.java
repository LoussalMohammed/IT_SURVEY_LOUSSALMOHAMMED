package org.itSurvey.survey.surveyEdition.surveyEditionDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import org.itSurvey.survey.subject.subjectDTO.ResponseSubjectDTO;

import java.time.LocalDate;
import java.util.List;

public record ResponseSurveyEditionDTO(
        @NotNull
        Long id,
        @Temporal(TemporalType.DATE)
        @Column(name = "creation_date")
        LocalDate creationDate,

        @Temporal(TemporalType.DATE)
        @Column(name = "start_date")
        LocalDate startDate,

        @NotNull
        @Column(name = "year")
        int year,
        List<ResponseSubjectDTO> subjects
)
{}
