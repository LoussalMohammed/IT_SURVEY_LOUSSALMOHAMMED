package org.itSurvey.survey.question.questionDTOMapper;

import org.itSurvey.survey.answer.answerDTOMapper.ResponseAnswerDTOMapper;
import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.question.questionDTO.ResponseQuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ResponseAnswerDTOMapper.class})
public interface ResponseQuestionDTOMapper {
    @Mapping(source = "answers", target = "answers")
    ResponseQuestionDTO toResponseQuestionDTO(Question question);
    
    @Mapping(target = "subject", ignore = true)
    Question toQuestion(ResponseQuestionDTO responseQuestionDTO);
} 