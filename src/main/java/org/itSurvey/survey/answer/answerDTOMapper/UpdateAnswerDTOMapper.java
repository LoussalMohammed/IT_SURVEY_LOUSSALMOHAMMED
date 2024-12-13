package org.itSurvey.survey.answer.answerDTOMapper;

import org.itSurvey.survey.answer.Answer;
import org.itSurvey.survey.answer.answerDTO.UpdateAnswerDTO;
import org.mapstruct.Mapper;

// Update Mapper

@Mapper(componentModel = "spring")
public interface UpdateAnswerDTOMapper {
    UpdateAnswerDTO toUpdateAnswerDTO(Answer answer);
    Answer toAnswer(UpdateAnswerDTO updateAnswerDTO);
} 