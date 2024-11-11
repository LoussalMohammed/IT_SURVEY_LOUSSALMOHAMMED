package org.itSurvey.survey.survey.surveyImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.owner.OwnerRepository;
import org.itSurvey.survey.survey.Survey;
import org.itSurvey.survey.survey.SurveyRepository;
import org.itSurvey.survey.survey.SurveyService;
import org.itSurvey.survey.survey.surveyDTO.RequestSurveyDTO;
import org.itSurvey.survey.survey.surveyDTO.ResponseSurveyDTO;
import org.itSurvey.survey.survey.surveyDTO.UpdateSurveyDTO;
import org.itSurvey.survey.survey.surveyDTOMapper.RequestSurveyDTOMapper;
import org.itSurvey.survey.survey.surveyDTOMapper.ResponseSurveyDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final RequestSurveyDTOMapper requestSurveyDTOMapper;
    private final ResponseSurveyDTOMapper responseSurveyDTOMapper;
    private final SurveyRepository surveyRepository;
    private final OwnerRepository ownerRepository;
    private final Logger logger = LoggerFactory.getLogger(SurveyServiceImpl.class);

    @Override
    public ResponseSurveyDTO createSurvey(RequestSurveyDTO requestSurveyDTO) {
        logger.info("transforming create survey dto into survey");
        Survey survey = requestSurveyDTOMapper.toSurvey(requestSurveyDTO);
        logger.info("saving survey {}", survey);
        Owner owner = ownerRepository.findByIdOrThrow(requestSurveyDTO.ownerId());
        owner.getSurveys().add(survey);
        survey.setOwner(owner);
        surveyRepository.save(survey);

        logger.info("returning response survey dto!");
        return responseSurveyDTOMapper.toResponseSurveyDTO(survey);
    }

    @Override
    public List<ResponseSurveyDTO> getAllSurveys() {
        logger.info("getting all surveys");
        List<Survey> surveys = surveyRepository.findAll();
        logger.info("transforming surveys into ResponseSurveyDTOs, and returning all of them");
        return surveys
                .stream()
                .map(responseSurveyDTOMapper::toResponseSurveyDTO)
                .toList();
    }

    @Override
    public ResponseSurveyDTO findSurveyById(Long id) {
        logger.info("finding survey by id, and throw exception if not found");
        Survey survey = surveyRepository.findByIdOrThrow(id);
        logger.info("transforming survey into response survey dto, and returning it");
        return responseSurveyDTOMapper.toResponseSurveyDTO(survey);
    }

    @Override
    public ResponseSurveyDTO updateSurveyById(UpdateSurveyDTO updateSurveyDTO, Long id) {
        Survey existingSurvey = surveyRepository.findByIdOrThrow(id);
        if(updateSurveyDTO.title() != null) {
            existingSurvey.setTitle(updateSurveyDTO.title());
        }

        if(updateSurveyDTO.description() != null) {
            existingSurvey.setDescription(updateSurveyDTO.description());
        }

        if(updateSurveyDTO.ownerId() != null) {
            Owner owner = ownerRepository.findByIdOrThrow(updateSurveyDTO.ownerId());
            existingSurvey.getOwner().getSurveys().remove(existingSurvey);
            existingSurvey.setOwner(owner);
            owner.getSurveys().add(existingSurvey);
        }

        surveyRepository.save(existingSurvey);
        return responseSurveyDTOMapper.toResponseSurveyDTO(existingSurvey);
    }

    @Override
    public ResponseSurveyDTO deleteById(Long id) {
        Survey survey = surveyRepository.findByIdOrThrow(id);
        surveyRepository.deleteById(id);
        return responseSurveyDTOMapper.toResponseSurveyDTO(survey);
    }

    @Override
    public ResponseSurveyDTO results(Long id) {
        Optional<Survey> survey = surveyRepository.findById(id);
        return responseSurveyDTOMapper.toResponseSurveyDTO(survey.get());
    }
}
