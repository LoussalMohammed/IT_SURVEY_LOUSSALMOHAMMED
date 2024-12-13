package org.itSurvey.survey.answer;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.answer.answerDTO.RequestAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.UpdateAnswerDTO;
import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.shared.dto.PageDTO;
import org.itSurvey.survey.utils.annotation.IdExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.itSurvey.survey.shared.constant.ApiConstants.DEFAULT_SORT_FIELD;

@RestController
@RequestMapping("/answer")
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

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public PageDTO<ResponseAnswerDTO> getAllAnswers(
            @PathVariable int page,
            @PathVariable int size,
            @RequestParam(defaultValue = DEFAULT_SORT_FIELD) String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        logger.info("Fetching all answers");
        return answerService.getAllAnswers(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseAnswerDTO getAnswerById(@PathVariable @IdExists(entityClass = Answer.class) Long id) {
        logger.info("Fetching answer with id: {}", id);
        return answerService.getAnswerById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
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
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseAnswerDTO> getAnswersByQuestionId(
            @PathVariable @IdExists(entityClass = Question.class) Long questionId) {
        logger.info("Fetching answers for question id: {}", questionId);
        return answerService.getAnswersByQuestionId(questionId);
    }
}
