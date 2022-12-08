package com.temporary.workforce.management.service;

import com.temporary.workforce.management.exception.BusinessException;
import org.springframework.stereotype.Component;
import com.temporary.workforce.management.repository.AccommodationRepository;
import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.model.Accommodation;
import com.temporary.workforce.management.model.Floor;
import com.temporary.workforce.management.model.Utility;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService implements AccommodationServiceInterface{

    @Autowired
    AccommodationRepository accommodationRepository;

    ModelMapper modelMapper = new ModelMapper();
    Logger logger = LoggerFactory.getLogger(AccommodationService.class);

    @Override
    public void createAccommodation(AccommodationDTO accommodationDTO) {
        logger.info("Starting accommodation creation");
        Accommodation accommodation = modelMapper.map(accommodationDTO, Accommodation.class);
        accommodationRepository.save(accommodation);
        logger.info("Accommodation created successfully " + accommodation.getId());
    }

    @Override
    public AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO) throws BusinessException {

        logger.info("Updating accommodation " + accommodationDTO.getId());
        Optional<Accommodation> existingAccommodationOpt = accommodationRepository.findById(accommodationDTO.getId());
        throwExceptionIfAccommodationNotFound(existingAccommodationOpt, accommodationDTO.getId());
        Accommodation existingAccommodation = existingAccommodationOpt.get();
        existingAccommodation = modelMapper.map(accommodationDTO, Accommodation.class);
        accommodationRepository.save(existingAccommodation);
//      existingAccommodationOpt.ifPresent(accommodation -> accommodationRepository.save(accommodation)); // already checked for AccommodationNotFound
        logger.info("Accommodation updated");
        return modelMapper.map(existingAccommodation, AccommodationDTO.class);



        /*
        existingAccommodation.setOwnersName(accommodationDTO.getOwnersName());
        existingAccommodation.setOwnersPhoneNumber(accommodationDTO.getOwnersPhoneNumber());
        existingAccommodation.setEmail(accommodationDTO.getEmail());
        existingAccommodation.setOwnershipType(accommodationDTO.getOwnershipType());
        existingAccommodation.setProvince(accommodationDTO.getProvince());
        existingAccommodation.setCity(accommodationDTO.getCity());
        existingAccommodation.setAddress(accommodationDTO.getAddress());
        existingAccommodation.setPostalCode(accommodationDTO.getPostalCode());
        existingAccommodation.setHouseNumber(accommodationDTO.getHouseNumber());
        existingAccommodation.setHasInternet(accommodationDTO.isHasInternet());
        existingAccommodation.setHasParking(accommodationDTO.isHasParking());
        existingAccommodation.setRent(accommodationDTO.getRent());
        existingAccommodation.setDeposit(accommodationDTO.getDeposit());
        existingAccommodation.setRentalPeriod(accommodationDTO.getRentalPeriod());
        existingAccommodation.setNoticePeriod(accommodationDTO.getNoticePeriod());

        List<Floor> floors = accommodationDTO.getFloors().stream().map(a -> modelMapper.map(a, Floor.class)).toList();
        List<Utility> utilities = accommodationDTO.getUtilities().stream().map(a -> modelMapper.map(a, Utility.class)).toList();
        floors.forEach(floor -> floor.setAccommodationId(existingAccommodation.getId()));
        utilities.forEach(utility -> utility.setAccommodationId(existingAccommodation.getId()));
        existingAccommodation.setFloors(floors);
        existingAccommodation.setUtilities(utilities);
        */
    }

    @Override
    public void deleteAccommodation(int accommodationId) throws BusinessException {
        logger.info("Deleting accommodation");
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);
        throwExceptionIfAccommodationNotFound(accommodation, accommodationId);
        accommodationRepository.deleteById(accommodationId);
        logger.info("Accommodation deleted");
    }

    @Override
    public AccommodationDTO getAccommodationDTO(int accommodationId) throws BusinessException {
        logger.info("Retrieving accommodationDTO");
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);
        throwExceptionIfAccommodationNotFound(accommodation, accommodationId);
        return modelMapper.map(accommodation, AccommodationDTO.class);
    }

    @Override
    public Optional<Accommodation> getAccommodation(int accommodationId) throws BusinessException {
        logger.info("Retrieving accommodation");
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);
        throwExceptionIfAccommodationNotFound(accommodation, accommodationId);
        return accommodation;
    }


    private void throwExceptionIfAccommodationNotFound(Optional<Accommodation> accommodation, int accommodationId) throws BusinessException {
        if(accommodation.isEmpty()){
            throw new BusinessException("Accommodation with ID " + accommodationId + " not found.");
        }
    }

}
