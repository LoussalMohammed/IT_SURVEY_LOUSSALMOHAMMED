package org.itSurvey.survey.question.questionDTOMapper;

import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.question.questionDTO.UpdateQuestionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateQuestionDTOMapper {
    UpdateQuestionDTO toUpdateQuestionDTO(Question question);
    Question toQuestion(UpdateQuestionDTO updateQuestionDTO);
} 