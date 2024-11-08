package org.itSurvey.survey.owner;

import lombok.RequiredArgsConstructor;
import org.itSurvey.survey.owner.ownerDTO.RequestOwnerDTO;
import org.itSurvey.survey.utils.exception.ResourceNotFoundException;
import org.itSurvey.survey.owner.ownerDTO.ResponseOwnerDTO;
import org.itSurvey.survey.owner.ownerDTO.UpdateOwnerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;
    private final static Logger logger = LoggerFactory.getLogger(OwnerController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseOwnerDTO createOwner(@RequestBody RequestOwnerDTO requestOwnerDTO) {
        logger.info("Creating owner Using createOwnerDTO {}", requestOwnerDTO);
        return ownerService.createOwner(requestOwnerDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<ResponseOwnerDTO> getAllOwners() {
        logger.info("Retrieving all Owners");
        return ownerService.getAllOwners();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseOwnerDTO findOwnerById(@PathVariable Long id) {
        logger.info("Finding Owner By Id: {}", id);
        return ownerService.findOwnerById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseOwnerDTO updateOwnerById(@RequestBody UpdateOwnerDTO updateOwnerDTO, @PathVariable Long id) {
        logger.info("Updating Owner By Id: {}", id);
        return ownerService.updateOwnerById(updateOwnerDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseOwnerDTO deleteOwnerById(@PathVariable Long id) {
        logger.info("Deleting Owner By Id: {}", id);
        return ownerService.deleteById(id);
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void error() {
        throw new ResourceNotFoundException("Error Handled Effectively!");
    }
}
