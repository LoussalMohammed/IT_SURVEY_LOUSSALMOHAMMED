package org.itSurvey.survey.question.questionDTOMapper;

import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.question.questionDTO.EmbeddableQuestionDTO;

public interface EmbeddableQuestionDTOMapper {
    EmbeddableQuestionDTO toEmbeddableQuestionDTO(Question question);
    Question toQuestion(EmbeddableQuestionDTO embeddableQuestionDTO);
}
