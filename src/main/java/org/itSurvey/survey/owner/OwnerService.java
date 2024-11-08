package org.itSurvey.survey.owner;

import org.itSurvey.survey.owner.ownerDTO.RequestOwnerDTO;
import org.itSurvey.survey.owner.ownerDTO.ResponseOwnerDTO;
import org.itSurvey.survey.owner.ownerDTO.UpdateOwnerDTO;

import java.util.List;

public interface OwnerService {
    ResponseOwnerDTO createOwner(RequestOwnerDTO requestOwnerDTO);
    List<ResponseOwnerDTO> getAllOwners();
    ResponseOwnerDTO updateOwnerById(UpdateOwnerDTO updateOwnerDTO, Long id);
    ResponseOwnerDTO findOwnerById(Long id);
    ResponseOwnerDTO deleteById(Long id);
}
