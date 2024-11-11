package org.itSurvey.survey.question.questionDTOMapper;

import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.question.questionDTO.RequestQuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequestQuestionDTOMapper {
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "answers", ignore = true)
    Question toQuestion(RequestQuestionDTO requestQuestionDTO);
    
    RequestQuestionDTO toRequestQuestionDTO(Question question);
} 