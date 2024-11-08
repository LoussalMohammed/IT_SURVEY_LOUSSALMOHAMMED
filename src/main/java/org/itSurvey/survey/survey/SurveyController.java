package org.itSurvey.survey.survey;

import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.survey.surveyDTO.RequestSurveyDTO;
import org.itSurvey.survey.utils.exception.ResourceNotFoundException;
import org.itSurvey.survey.survey.surveyDTO.ResponseSurveyDTO;
import org.itSurvey.survey.survey.surveyDTO.UpdateSurveyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/survey")
@Validated
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;
    private final static Logger logger = LoggerFactory.getLogger(SurveyController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseSurveyDTO createSurvey(@RequestBody RequestSurveyDTO requestSurveyDTO) {
        logger.info("Creating survey Using createSurveyDTO {}", requestSurveyDTO);
        return surveyService.createSurvey(requestSurveyDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ResponseSurveyDTO> getAllSurveys() {
        logger.info("Retrieving all Surveys");
        return surveyService.getAllSurveys();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSurveyDTO findSurveyById(@PathVariable Long id) {
        logger.info("Finding Survey By Id: {}", id);
        return surveyService.findSurveyById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSurveyDTO updateSurveyById(@RequestBody UpdateSurveyDTO updateSurveyDTO, @PathVariable Long id) {
        logger.info("Updating Survey By Id: {}", id);
        return surveyService.updateSurveyById(updateSurveyDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSurveyDTO deleteSurveyById(@PathVariable Long id) {
        logger.info("Deleting Survey By Id: {}", id);
        return surveyService.deleteById(id);
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void error() {
        throw new ResourceNotFoundException("Error Handled Effectively!");
    }

}
