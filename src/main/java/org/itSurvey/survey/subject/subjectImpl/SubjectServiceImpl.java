package org.itSurvey.survey.subject.subjectImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.subject.SubjectRepository;
import org.itSurvey.survey.subject.SubjectService;
import org.itSurvey.survey.subject.subjectDTO.RequestSubjectDTO;
import org.itSurvey.survey.subject.subjectDTO.ResponseSubjectDTO;
import org.itSurvey.survey.subject.subjectDTO.UpdateSubjectDTO;
import org.itSurvey.survey.subject.subjectDTOMapper.RequestSubjectDTOMapper;
import org.itSurvey.survey.subject.subjectDTOMapper.ResponseSubjectDTOMapper;
import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.surveyEdition.SurveyEditionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {
    private final ResponseSubjectDTOMapper responseSubjectDTOMapper;
    private final RequestSubjectDTOMapper requestSubjectDTOMapper;
    private final SubjectRepository subjectRepository;
    private final SurveyEditionRepository surveyEditionRepository;
    private final Logger logger = LoggerFactory.getLogger(SubjectServiceImpl.class);

    @Override
    public ResponseSubjectDTO createSubject(RequestSubjectDTO requestSubjectDTO) {
        logger.info("transforming create subject dto into subject");
        Subject subject = requestSubjectDTOMapper.toSubject(requestSubjectDTO);
        logger.info("saving subject {}", subject);
        SurveyEdition surveyEdition = surveyEditionRepository.findByIdOrThrow(requestSubjectDTO.surveyEditionId());
        surveyEdition.getSubjects().add(subject);
        subject.setSurveyEdition(surveyEdition);

        if(requestSubjectDTO.parentSubjectId() != null) {
            Subject parentSubject = subjectRepository.findByIdOrThrow(requestSubjectDTO.parentSubjectId());
            parentSubject.getSubjects().add(subject);
            subject.setParentSubject(parentSubject);
        }

        subjectRepository.save(subject);

        logger.info("returning response subject dto!");
        return responseSubjectDTOMapper.toResponseSubjectDTO(subject);
    }

    @Override
    public List<ResponseSubjectDTO> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects
                .stream()
                .map(responseSubjectDTOMapper::toResponseSubjectDTO)
                .toList();
    }

    @Override
    public ResponseSubjectDTO updateSubjectById(UpdateSubjectDTO updateSubjectDTO, Long id) {
        Subject existingSubject = subjectRepository.findByIdOrThrow(id);

        if(updateSubjectDTO.title() != null) {
            existingSubject.setTitle(updateSubjectDTO.title());
        }

        if(updateSubjectDTO.parentSubjectId() != null) {
            Subject parentSubject = subjectRepository.findByIdOrThrow(updateSubjectDTO.parentSubjectId());
            existingSubject.getParentSubject().getSubjects().remove(existingSubject);
            existingSubject.setParentSubject(parentSubject);
            parentSubject.getSubjects().add(existingSubject);
        }

        if(updateSubjectDTO.surveyEditionId() != null) {
            SurveyEdition surveyEdition = surveyEditionRepository.findByIdOrThrow(updateSubjectDTO.surveyEditionId());
            existingSubject.getSurveyEdition().getSubjects().remove(existingSubject);
            existingSubject.setSurveyEdition(surveyEdition);
            surveyEdition.getSubjects().add(existingSubject);
        }

        subjectRepository.save(existingSubject);

        return responseSubjectDTOMapper.toResponseSubjectDTO(existingSubject);
    }

    @Override
    public ResponseSubjectDTO findSubjectById(Long id) {
        Subject subject = subjectRepository.findByIdOrThrow(id);
        return responseSubjectDTOMapper.toResponseSubjectDTO(subject);
    }

    @Override
    public ResponseSubjectDTO deleteById(Long id) {
        Subject subject = subjectRepository.findByIdOrThrow(id);
        subject.getParentSubject().getSubjects().remove(subject);
        subjectRepository.deleteById(id);
        return responseSubjectDTOMapper.toResponseSubjectDTO(subject);
    }
}
