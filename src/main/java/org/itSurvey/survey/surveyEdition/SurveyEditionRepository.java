package org.itSurvey.survey.surveyEdition;

import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.utils.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyEditionRepository extends JpaRepository<SurveyEdition, Long> {

    default SurveyEdition findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Survey Edition Not Found Using Specified id!"));
    }
}
