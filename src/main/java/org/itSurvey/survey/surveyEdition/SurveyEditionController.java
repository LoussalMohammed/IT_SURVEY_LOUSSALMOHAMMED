package org.itSurvey.survey.surveyEdition;

import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.RequestSurveyEditionDTO;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.ResponseSurveyEditionDTO;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.UpdateSurveyEditionDTO;
import org.itSurvey.survey.utils.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/surveyEditionEdition")
@RequiredArgsConstructor
public class SurveyEditionController {

    private final SurveyEditionService surveyEditionService;
    private final static Logger logger = LoggerFactory.getLogger(SurveyEditionController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseSurveyEditionDTO createSurveyEdition(@RequestBody RequestSurveyEditionDTO requestSurveyEditionDTO) {
        logger.info("Creating surveyEdition Using createSurveyEditionDTO {}", requestSurveyEditionDTO);
        return surveyEditionService.createSurveyEdition(requestSurveyEditionDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ResponseSurveyEditionDTO> getAllSurveyEditions() {
        logger.info("Retrieving all SurveyEditions");
        return surveyEditionService.getAllSurveyEditions();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSurveyEditionDTO findSurveyEditionById(@PathVariable Long id) {
        logger.info("Finding SurveyEdition By Id: {}", id);
        return surveyEditionService.findSurveyEditionById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSurveyEditionDTO updateSurveyEditionById(@RequestBody UpdateSurveyEditionDTO updateSurveyEditionDTO, @PathVariable Long id) {
        logger.info("Updating SurveyEdition By Id: {}", id);
        return surveyEditionService.updateSurveyEditionById(updateSurveyEditionDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSurveyEditionDTO deleteSurveyEditionById(@PathVariable Long id) {
        logger.info("Deleting SurveyEdition By Id: {}", id);
        return surveyEditionService.deleteById(id);
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void error() {
        throw new ResourceNotFoundException("Error Handled Effectively!");
    }

}
