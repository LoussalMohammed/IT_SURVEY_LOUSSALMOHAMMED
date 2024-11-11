package org.itSurvey.survey.answer;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.answer.answerDTO.RequestAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.UpdateAnswerDTO;
import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.utils.annotation.IdExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/answer")
@RequiredArgsConstructor
@Validated
@Tag(name = "Answer Controller")
public class AnswerController {
    private final AnswerService answerService;
    private final static Logger logger = LoggerFactory.getLogger(AnswerController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseAnswerDTO createAnswer(@Valid @RequestBody RequestAnswerDTO requestAnswerDTO) {
        logger.info("Creating answer: {}", requestAnswerDTO);
        return answerService.createAnswer(requestAnswerDTO);
    }

    @GetMapping
    public List<ResponseAnswerDTO> getAllAnswers() {
        logger.info("Fetching all answers");
        return answerService.getAllAnswers();
    }

    @GetMapping("/{id}")
    public ResponseAnswerDTO getAnswerById(@PathVariable @IdExists(entityClass = Answer.class) Long id) {
        logger.info("Fetching answer with id: {}", id);
        return answerService.getAnswerById(id);
    }

    @PatchMapping("/{id}")
    public ResponseAnswerDTO updateAnswerById(
            @RequestBody UpdateAnswerDTO updateAnswerDTO,
            @PathVariable @IdExists(entityClass = Answer.class) Long id) {
        logger.info("Updating answer with id: {}", id);
        return answerService.updateAnswerById(updateAnswerDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAnswerById(@PathVariable @IdExists(entityClass = Answer.class) Long id) {
        logger.info("Deleting answer with id: {}", id);
        answerService.deleteAnswerById(id);
    }

    @GetMapping("/question/{questionId}")
    public List<ResponseAnswerDTO> getAnswersByQuestionId(
            @PathVariable @IdExists(entityClass = Question.class) Long questionId) {
        logger.info("Fetching answers for question id: {}", questionId);
        return answerService.getAnswersByQuestionId(questionId);
    }
}
