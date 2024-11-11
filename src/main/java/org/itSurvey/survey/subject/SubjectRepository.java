package org.itSurvey.survey.subject;

import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.utils.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    default Subject findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject Not Found Using Specified id!"));
    }
}
