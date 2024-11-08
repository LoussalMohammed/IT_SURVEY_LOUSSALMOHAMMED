package org.itSurvey.survey.surveyEdition.surveyEditionImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.survey.SurveyRepository;
import org.itSurvey.survey.surveyEdition.SurveyEdition;
import org.itSurvey.survey.surveyEdition.SurveyEditionRepository;
import org.itSurvey.survey.surveyEdition.SurveyEditionService;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.RequestSurveyEditionDTO;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.ResponseSurveyEditionDTO;
import org.itSurvey.survey.surveyEdition.surveyEditionDTO.UpdateSurveyEditionDTO;
import org.itSurvey.survey.surveyEdition.surveyEditionDTOMapper.RequestSurveyEditionDTOMapper;
import org.itSurvey.survey.surveyEdition.surveyEditionDTOMapper.ResponseSurveyEditionDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SurveyEditionServiceImpl implements SurveyEditionService {
    private final RequestSurveyEditionDTOMapper requestSurveyEditionDTOMapper;
    private final ResponseSurveyEditionDTOMapper responseSurveyEditionDTOMapper;
    private final SurveyEditionRepository surveyEditionRepository;
    private final SurveyRepository surveyRepository;
    private final Logger logger = LoggerFactory.getLogger(SurveyEditionServiceImpl.class);

    @Override
    public ResponseSurveyEditionDTO createSurveyEdition(RequestSurveyEditionDTO requestSurveyEditionDTO) {
        SurveyEdition surveyEdition = requestSurveyEditionDTOMapper.toSurveyEdition(requestSurveyEditionDTO);
        Survey survey = surveyRepository.findByIdOrThrow(requestSurveyEditionDTO.surveyId());
        survey.getSurveyEditions().add(surveyEdition);
        surveyEdition.setSurvey(survey);
        surveyEditionRepository.save(surveyEdition);
        return responseSurveyEditionDTOMapper.toResponseSurveyEditionDTO(surveyEdition);
    }

    @Override
    public List<ResponseSurveyEditionDTO> getAllSurveyEditions() {
        List<SurveyEdition> surveyEditions = surveyEditionRepository.findAll();
        return surveyEditions.stream()
                .map(responseSurveyEditionDTOMapper::toResponseSurveyEditionDTO)
                .toList();
    }

    @Override
    public ResponseSurveyEditionDTO findSurveyEditionById(Long id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findByIdOrThrow(id);
        return responseSurveyEditionDTOMapper.toResponseSurveyEditionDTO(surveyEdition);
    }

    @Override
    public ResponseSurveyEditionDTO updateSurveyEditionById(UpdateSurveyEditionDTO updateSurveyEditionDTO, Long id) {
        SurveyEdition existingSurveyEdition = surveyEditionRepository.findByIdOrThrow(id);
        if(updateSurveyEditionDTO.creationDate() != null) {
            existingSurveyEdition.setCreationDate(updateSurveyEditionDTO.creationDate());
        }
        if(updateSurveyEditionDTO.startDate() != null) {
            existingSurveyEdition.setStartDate(updateSurveyEditionDTO.startDate());
        }
        if(updateSurveyEditionDTO.year() >= LocalDate.now().getYear()) {
            existingSurveyEdition.setStartDate(updateSurveyEditionDTO.startDate());
        }

        if(updateSurveyEditionDTO.surveyId() != null) {
            Survey survey = surveyRepository.findByIdOrThrow(updateSurveyEditionDTO.surveyId());
            existingSurveyEdition.setSurvey(survey);
        }

        surveyEditionRepository.save(existingSurveyEdition);
        return responseSurveyEditionDTOMapper.toResponseSurveyEditionDTO(existingSurveyEdition);
    }

    @Override
    public ResponseSurveyEditionDTO deleteById(Long id) {
        SurveyEdition surveyEdition = surveyEditionRepository.findByIdOrThrow(id);
        surveyEditionRepository.deleteById(id);
        return responseSurveyEditionDTOMapper.toResponseSurveyEditionDTO(surveyEdition);
    }
}
