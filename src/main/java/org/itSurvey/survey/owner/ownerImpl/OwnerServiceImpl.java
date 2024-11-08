package org.itSurvey.survey.owner.ownerImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.owner.Owner;
import org.itSurvey.survey.owner.OwnerRepository;
import org.itSurvey.survey.owner.OwnerService;
import org.itSurvey.survey.owner.ownerDTO.RequestOwnerDTO;
import org.itSurvey.survey.owner.ownerDTO.ResponseOwnerDTO;
import org.itSurvey.survey.owner.ownerDTO.UpdateOwnerDTO;
import org.itSurvey.survey.owner.ownerDTOMapper.RequestOwnerDTOMapper;
import org.itSurvey.survey.owner.ownerDTOMapper.ResponseOwnerDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final RequestOwnerDTOMapper requestOwnerDTOMapper;
    private final ResponseOwnerDTOMapper responseOwnerDTOMapper;
    private final OwnerRepository ownerRepository;
    private final static Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

    @Override
    public ResponseOwnerDTO createOwner(RequestOwnerDTO requestOwnerDTO) {
        logger.info("transforming create owner dto into owner");
        Owner owner = requestOwnerDTOMapper.toOwner(requestOwnerDTO);
        logger.info("saving owner {}", owner);
        ownerRepository.save(owner);
        return responseOwnerDTOMapper.toResponseOwnerDTO(owner);
    }

    @Override
    public List<ResponseOwnerDTO> getAllOwners() {
        logger.info("getting all owners");
        List<Owner> owners = ownerRepository.findAll();
        logger.info("transforming owners into ResponseOwnerDTOs, and returning all of them");
        return owners
                .stream()
                .map(responseOwnerDTOMapper::toResponseOwnerDTO)
                .toList();
    }

    @Override
    public ResponseOwnerDTO findOwnerById(Long id) {
        logger.info("finding owner by id, and throw exception if not found");
        Owner owner = ownerRepository.findByIdOrThrow(id);
        logger.info("transforming owner into response owner dto, and returning it");
        return responseOwnerDTOMapper.toResponseOwnerDTO(owner);
    }

    @Override
    public ResponseOwnerDTO updateOwnerById(UpdateOwnerDTO updateOwnerDTO, Long id) {
        logger.info("finding existing owner by id, and throw exception if not found");
        Owner existingOwner = ownerRepository.findByIdOrThrow(id);
        if(updateOwnerDTO.name() != null) {
            existingOwner.setName(updateOwnerDTO.name());
        }

        existingOwner.setSurveys(updateOwnerDTO.surveys());

        ownerRepository.save(existingOwner);
        return responseOwnerDTOMapper.toResponseOwnerDTO(existingOwner);
    }

    @Override
    public ResponseOwnerDTO deleteById(Long id) {
        logger.info("finding owner by id, and throw exception if not found");
        Owner existingOwner = ownerRepository.findByIdOrThrow(id);
        ownerRepository.deleteById(id);
        return responseOwnerDTOMapper.toResponseOwnerDTO(existingOwner);
    }
}
