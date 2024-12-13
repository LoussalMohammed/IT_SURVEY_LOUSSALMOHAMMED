package org.itSurvey.survey.answer.answerImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.answer.Answer;
import org.itSurvey.survey.answer.AnswerRepository;
import org.itSurvey.survey.answer.AnswerService;
import org.itSurvey.survey.answer.answerDTO.RequestAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.ResponseAnswerDTO;
import org.itSurvey.survey.answer.answerDTO.UpdateAnswerDTO;
import org.itSurvey.survey.answer.answerDTOMapper.RequestAnswerDTOMapper;
import org.itSurvey.survey.answer.answerDTOMapper.ResponseAnswerDTOMapper;
import org.itSurvey.survey.question.Question;
import org.itSurvey.survey.question.QuestionRepository;
import org.itSurvey.survey.shared.dto.PageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final RequestAnswerDTOMapper requestAnswerDTOMapper;
    private final ResponseAnswerDTOMapper responseAnswerDTOMapper;
    private final static Logger logger = LoggerFactory.getLogger(AnswerServiceImpl.class);

    @Override
    public ResponseAnswerDTO createAnswer(RequestAnswerDTO requestAnswerDTO) {
        logger.info("Creating new answer");
        Answer answer = requestAnswerDTOMapper.toAnswer(requestAnswerDTO);
        
        Question question = questionRepository.findByIdOrThrow(requestAnswerDTO.questionId());
        answer.setQuestion(question);
        question.getAnswers().add(answer);
        
        answerRepository.save(answer);
        return responseAnswerDTOMapper.toResponseAnswerDTO(answer);
    }

    @Override
    public PageDTO<ResponseAnswerDTO> getAllAnswers(Pageable pageable) {
        logger.info("Fetching all answers");
        Page<Answer> answerPage = answerRepository.findAll(pageable);
        Page<ResponseAnswerDTO> responsePage = answerPage.map(responseAnswerDTOMapper::toResponseAnswerDTO);
        return PageDTO.of(responsePage);
    }

    @Override
    public ResponseAnswerDTO getAnswerById(Long id) {
        logger.info("Fetching answer with id: {}", id);
        Answer answer = answerRepository.findByIdOrThrow(id);
        return responseAnswerDTOMapper.toResponseAnswerDTO(answer);
    }

    @Override
    public ResponseAnswerDTO updateAnswerById(UpdateAnswerDTO updateAnswerDTO, Long id) {
        Answer existingAnswer = answerRepository.findByIdOrThrow(id);
        
        if (updateAnswerDTO.text() != null) {
            existingAnswer.setText(updateAnswerDTO.text());
        }
        
        return responseAnswerDTOMapper.toResponseAnswerDTO(existingAnswer);
    }

    @Override
    public void deleteAnswerById(Long id) {
        logger.info("Deleting answer with id: {}", id);
        answerRepository.deleteById(id);
    }

    @Override
    public List<ResponseAnswerDTO> getAnswersByQuestionId(Long questionId) {
        logger.info("Fetching answers for question id: {}", questionId);
        return answerRepository.findByQuestionId(questionId)
                .stream()
                .map(responseAnswerDTOMapper::toResponseAnswerDTO)
                .toList();
    }
}
