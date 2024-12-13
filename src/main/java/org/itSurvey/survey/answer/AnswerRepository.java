package org.itSurvey.survey.answer;

import org.itSurvey.survey.shared.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    default Answer findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("Answer Not Found Using Specified id: {}"));
    }
    List<Answer> findByQuestionId(Long id);
}
