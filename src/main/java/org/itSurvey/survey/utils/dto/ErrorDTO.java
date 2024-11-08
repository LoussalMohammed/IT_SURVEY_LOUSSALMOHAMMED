package org.itSurvey.survey.utils.dto;

import java.time.LocalDateTime;

public record ErrorDTO(
        String message,
        LocalDateTime timestamp
)
{}