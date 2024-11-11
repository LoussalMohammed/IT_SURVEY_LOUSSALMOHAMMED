package org.itSurvey.survey.answer.answerDTOMapper;

import org.itSurvey.survey.answer.Answer;
import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponseAnswerDTOMapper {
    ResponseAnswerDTO toResponseAnswerDTO(Answer answer);
    
    @Mapping(target = "question", ignore = true)
    Answer toAnswer(ResponseAnswerDTO responseAnswerDTO);
} 