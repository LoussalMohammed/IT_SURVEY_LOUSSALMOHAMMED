package org.itSurvey.survey.utils.exception;

import org.itSurvey.survey.utils.dto.ErrorDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorDTO resourceNotFoundHandler(ResourceNotFoundException re) {
        return new ErrorDTO(
                re.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(Exception.class)
    public ErrorDTO globalExceptionHandler(Exception e) {
        return new ErrorDTO(
                e.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(ValidationException.class)
    public ErrorDTO validationExceptionHandler(ValidationException ve) {
        return new ErrorDTO(
                ve.getMessage(),
                LocalDateTime.now()
        );
    }
}
