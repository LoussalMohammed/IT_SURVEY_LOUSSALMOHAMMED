package org.itSurvey.survey.question.questionImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.itSurvey.survey.answer.Answer;
import org.itSurvey.survey.answer.AnswerRepository;
import org.itSurvey.survey.answer.answerDTOMapper.ResponseAnswerDTOMapper;
import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.question.QuestionRepository;
import org.itSurvey.survey.question.QuestionService;
import org.itSurvey.survey.question.questionDTO.CountDTO;
import org.itSurvey.survey.question.questionDTO.RequestQuestionDTO;
import org.itSurvey.survey.question.questionDTO.ResponseQuestionDTO;
import org.itSurvey.survey.question.questionDTO.UpdateQuestionDTO;
import org.itSurvey.survey.question.questionDTOMapper.RequestQuestionDTOMapper;
import org.itSurvey.survey.question.questionDTOMapper.ResponseQuestionDTOMapper;
import org.itSurvey.survey.subject.Subject;
import org.itSurvey.survey.subject.SubjectRepository;
import org.itSurvey.survey.utils.enums.QuestionType;
import org.itSurvey.survey.utils.exception.ValidationException;
import org.itSurvey.survey.utils.validation.SubjectValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final SubjectRepository subjectRepository;
    private final RequestQuestionDTOMapper requestQuestionDTOMapper;
    private final ResponseQuestionDTOMapper responseQuestionDTOMapper;
    private final ResponseAnswerDTOMapper responseAnswerDTOMapper;

    @Override
    public ResponseQuestionDTO createQuestion(RequestQuestionDTO requestQuestionDTO) {
        log.info("Creating new question");
        Question question = requestQuestionDTOMapper.toQuestion(requestQuestionDTO);
        
        // Find and validate subject
        Subject subject = subjectRepository.findByIdOrThrow(requestQuestionDTO.subjectId());
        
        // Validate subject hierarchy
        SubjectValidator.validateSubjectForQuestions(subject);
        
        // Set up bidirectional relationship
        question.setSubject(subject);
        if (subject.getQuestions() == null) {
            subject.setQuestions(new ArrayList<>());
        }
        subject.getQuestions().add(question);
        
        Question savedQuestion = questionRepository.save(question);
        return responseQuestionDTOMapper.toResponseQuestionDTO(savedQuestion);
    }

    @Override
    public List<ResponseQuestionDTO> getAllQuestions() {
        log.info("Fetching all questions");
        return questionRepository.findAll()
                .stream()
                .map(responseQuestionDTOMapper::toResponseQuestionDTO)
                .toList();
    }

    @Override
    public ResponseQuestionDTO getQuestionById(Long id) {
        log.info("Fetching question with id: {}", id);
        Question question = questionRepository.findByIdOrThrow(id);
        return responseQuestionDTOMapper.toResponseQuestionDTO(question);
    }

    @Override
    public ResponseQuestionDTO updateQuestionById(UpdateQuestionDTO updateQuestionDTO, Long id) {
        Question existingQuestion = questionRepository.findByIdOrThrow(id);
        
        if (updateQuestionDTO.text() != null) {
            existingQuestion.setText(updateQuestionDTO.text());
        }
        if (updateQuestionDTO.questionType() != null) {
            existingQuestion.setQuestionType(updateQuestionDTO.questionType());
        }
        
        return responseQuestionDTOMapper.toResponseQuestionDTO(existingQuestion);
    }

    @Override
    public void deleteQuestionById(Long id) {
        log.info("Deleting question with id: {}", id);
        questionRepository.deleteById(id);
    }

    @Override
    public List<ResponseQuestionDTO> getQuestionsBySubjectId(Long subjectId) {
        log.info("Fetching questions for subject id: {}", subjectId);
        return questionRepository.findBySubjectId(subjectId)
                .stream()
                .map(responseQuestionDTOMapper::toResponseQuestionDTO)
                .toList();
    }

    @Override
    public CountDTO answerQuestionById(Long questionId, List<Long> answersIds) {
        Question question = questionRepository.findByIdOrThrow(questionId);
        List<Answer> answers = answersIds
                .stream()
                .map(answerRepository::findByIdOrThrow)
                .toList();

        CountDTO countDTO;

        if(question.getQuestionType().equals(QuestionType.SINGLE_CHOICE)) {
            Answer answer = answers.getFirst();
            question.setAnswerCount(question.getAnswerCount() != null ? question.getAnswerCount()+1 : 1);
            answer.setSelectionCount(answer.getSelectionCount() != null ? answer.getSelectionCount()+1 : 1);
            countDTO = new  CountDTO(
                    question.getText(),
                    question.getAnswerCount(),
                    List.of(responseAnswerDTOMapper.toResponseAnswerDTO(answer))
            );
        }
        else    {
            answers.forEach((answer) -> {
                if(question.getAnswers().contains(answer)) {
                    question.setAnswerCount(question.getAnswerCount() != null ? question.getAnswerCount()+1 : 1);
                    answer.setSelectionCount(answer.getSelectionCount() != null ? answer.getSelectionCount()+1 : 1);
                }

            });

            countDTO = new CountDTO(
                    question.getText(),
                    question.getAnswerCount(),
                    answers
                            .stream()
                            .map(responseAnswerDTOMapper::toResponseAnswerDTO)
                            .toList()
            );
        }


        return countDTO;
    }
}
