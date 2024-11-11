package org.itSurvey.survey.survey;

import org.itSurvey.survey.utils.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    default Survey findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey Not Found Using Specified id!"));
    }
}
