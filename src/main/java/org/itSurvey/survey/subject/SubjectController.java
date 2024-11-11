package org.itSurvey.survey.subject;

import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.subject.subjectDTO.RequestSubjectDTO;
import org.itSurvey.survey.subject.subjectDTO.ResponseSubjectDTO;
import org.itSurvey.survey.subject.subjectDTO.UpdateSubjectDTO;
import org.itSurvey.survey.utils.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
@Validated
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    private final static Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseSubjectDTO createSubject(@RequestBody RequestSubjectDTO requestSubjectDTO) {
        logger.info("Creating subject Using createSubjectDTO {}", requestSubjectDTO);
        return subjectService.createSubject(requestSubjectDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ResponseSubjectDTO> getAllSubjects() {
        logger.info("Retrieving all Subjects");
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSubjectDTO findSubjectById(@PathVariable Long id) {
        logger.info("Finding Subject By Id: {}", id);
        return subjectService.findSubjectById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSubjectDTO updateSubjectById(@RequestBody UpdateSubjectDTO updateSubjectDTO, @PathVariable Long id) {
        logger.info("Updating Subject By Id: {}", id);
        return subjectService.updateSubjectById(updateSubjectDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSubjectDTO deleteSubjectById(@PathVariable Long id) {
        logger.info("Deleting Subject By Id: {}", id);
        return subjectService.deleteById(id);
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void error() {
        throw new ResourceNotFoundException("Error Handled Effectively!");
    }
}
