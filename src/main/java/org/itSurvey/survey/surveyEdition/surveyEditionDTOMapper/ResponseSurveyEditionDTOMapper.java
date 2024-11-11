package org.itSurvey.survey.surveyEdition.surveyEditionDTOMapper;

import org.itSurvey.survey.subject.subjectDTOMapper.ResponseSubjectDTOMapper;
import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.ResponseSurveyEditionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ResponseSubjectDTOMapper.class})
public interface ResponseSurveyEditionDTOMapper {
    @Mapping(source = "subjects", target = "subjects")
    ResponseSurveyEditionDTO toResponseSurveyEditionDTO(SurveyEdition surveyEdition);
    SurveyEdition toSurveyEdition(ResponseSurveyEditionDTO responseSurveyEditionDTO);
}
