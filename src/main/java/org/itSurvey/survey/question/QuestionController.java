package org.itSurvey.survey.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.question.questionDTO.CountDTO;
import org.itSurvey.survey.question.questionDTO.RequestQuestionDTO;
import org.itSurvey.survey.question.questionDTO.ResponseQuestionDTO;
import org.itSurvey.survey.question.questionDTO.UpdateQuestionDTO;
import org.itSurvey.survey.shared.dto.PageDTO;
import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.utils.annotation.IdExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.itSurvey.survey.shared.constant.ApiConstants.DEFAULT_SORT_FIELD;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final static Logger logger = LoggerFactory.getLogger(QuestionController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseQuestionDTO createQuestion(@Valid @RequestBody RequestQuestionDTO requestQuestionDTO) {
        logger.info("Creating question: {}", requestQuestionDTO);
        return questionService.createQuestion(requestQuestionDTO);
    }

    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public PageDTO<ResponseQuestionDTO> getAllQuestions(
            @PathVariable int page,
            @PathVariable int size,
            @RequestParam(defaultValue = DEFAULT_SORT_FIELD) String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        logger.info("Fetching all questions");
        return questionService.getAllQuestions(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseQuestionDTO getQuestionById(@PathVariable @IdExists(entityClass = Question.class) Long id) {
        logger.info("Fetching question with id: {}", id);
        return questionService.getQuestionById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseQuestionDTO updateQuestionById(
            @RequestBody UpdateQuestionDTO updateQuestionDTO,
            @PathVariable @IdExists(entityClass = Question.class) Long id) {
        logger.info("Updating question with id: {}", id);
        return questionService.updateQuestionById(updateQuestionDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestionById(@PathVariable @IdExists(entityClass = Question.class) Long id) {
        logger.info("Deleting question with id: {}", id);
        questionService.deleteQuestionById(id);
    }

    @GetMapping("/subject/{subjectId}")
    public List<ResponseQuestionDTO> getQuestionsBySubjectId(
            @PathVariable @IdExists(entityClass = Subject.class) Long subjectId) {
        logger.info("Fetching questions for subject id: {}", subjectId);
        return questionService.getQuestionsBySubjectId(subjectId);
    }

    @GetMapping("/participate/question/{questionId}/answers/{answersIds}")
    @ResponseStatus(HttpStatus.OK)
    public CountDTO answerQuestion(
            @PathVariable @IdExists(entityClass = Question.class) Long questionId,
            @PathVariable List<Long> answersIds) {
        return  questionService.answerQuestionById(questionId, answersIds);
    }

}