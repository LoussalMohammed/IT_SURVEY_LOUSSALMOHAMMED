package org.itSurvey.survey.utils.validation;

import lombok.experimental.UtilityClass;
import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.utils.exception.ValidationException;

@UtilityClass
public class SubjectValidator {
    
    public static void validateSubjectForQuestions(Subject subject) {
        // Check if subject has sub-subjects
        if (subject.getSubjects() != null && !subject.getSubjects().isEmpty()) {
            throw new ValidationException("Cannot add questions to a subject that has sub-subjects");
        }

        // Check if parent has other children (siblings)
        Subject parentSubject = subject.getParentSubject();
        if (parentSubject != null && 
            parentSubject.getSubjects() != null && 
            parentSubject.getSubjects().size() > 1) {
            throw new ValidationException("Cannot add questions to a subject that has siblings");
        }
    }
}