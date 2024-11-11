package org.itSurvey.survey.subject;


import org.itSurvey.survey.subject.subjectDTO.RequestSubjectDTO;
import org.itSurvey.survey.subject.subjectDTO.ResponseSubjectDTO;
import org.itSurvey.survey.subject.subjectDTO.UpdateSubjectDTO;

import java.util.List;

public interface SubjectService {
    ResponseSubjectDTO createSubject(RequestSubjectDTO requestSubjectDTO);
    List<ResponseSubjectDTO> getAllSubjects();
    ResponseSubjectDTO updateSubjectById(UpdateSubjectDTO updateSubjectDTO, Long id);
    ResponseSubjectDTO findSubjectById(Long id);
    ResponseSubjectDTO deleteById(Long id);
}
