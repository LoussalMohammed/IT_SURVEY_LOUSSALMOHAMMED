package org.itSurvey.survey.answer.answerDTOMapper;

import org.itSurvey.survey.answer.Answer;
import org.itSurvey.survey.answer.answerDTO.RequestAnswerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

// Request Mapper

@Mapper(componentModel = "spring")
public interface RequestAnswerDTOMapper {
    @Mapping(target = "question", ignore = true)
    Answer toAnswer(RequestAnswerDTO requestAnswerDTO);
    
    RequestAnswerDTO toRequestAnswerDTO(Answer answer);
} 