package org.itSurvey.survey.subject.subjectDTOMapper;

import java.util.stream.Collectors;

import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.question.questionDTOMapper.ResponseQuestionDTOMapper;
import org.itSurvey.survey.subject.subjectDTO.ResponseSubjectDTO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ResponseQuestionDTOMapper.class})
public interface ResponseSubjectDTOMapper {
    @Mapping(source = "subjects", target = "subSubjects")
    @Mapping(source = "questions", target = "questions")
    ResponseSubjectDTO toResponseSubjectDTO(Subject subject);
    
    default List<ResponseSubjectDTO> mapSubjects(List<Subject> subjects) {
        if (subjects == null) {
            return null;
        }
        return subjects.stream()
                .map(this::toResponseSubjectDTO)
                .collect(Collectors.toList());
    }
    
    @Mapping(source = "subSubjects", target = "subjects")
    @Mapping(source = "questions", target = "questions")
    @Mapping(target = "parentSubject", ignore = true)
    @Mapping(target = "surveyEdition", ignore = true)
    Subject toSubject(ResponseSubjectDTO responseSubjectDTO);
}
