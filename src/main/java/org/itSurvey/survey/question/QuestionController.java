package org.itSurvey.survey.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.question.questionDTO.CountDTO;
import org.itSurvey.survey.question.questionDTO.RequestQuestionDTO;
import org.itSurvey.survey.question.questionDTO.ResponseQuestionDTO;
import org.itSurvey.survey.question.questionDTO.UpdateQuestionDTO;
import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.utils.annotation.IdExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
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

    @GetMapping
    public List<ResponseQuestionDTO> getAllQuestions() {
        logger.info("Fetching all questions");
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseQuestionDTO getQuestionById(@PathVariable @IdExists(entityClass = Question.class) Long id) {
        logger.info("Fetching question with id: {}", id);
        return questionService.getQuestionById(id);
    }

    @PatchMapping("/{id}")
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

    @GetMapping("/question/{questionId}/answers/{answersIds}")
    @ResponseStatus(HttpStatus.CREATED)
    public CountDTO answerQuestion(
            @PathVariable @IdExists(entityClass = Question.class) Long questionId,
            @PathVariable List<Long> answersIds) {
        return  questionService.answerQuestionById(questionId, answersIds);
    }
}