package org.itSurvey.survey.question;

import org.itSurvey.survey.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    default Question findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("Question Not Found Using Specified id: {}"));
    }

    List<Question> findBySubjectId(Long id);
}
