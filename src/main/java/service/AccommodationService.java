package service;

import dto.AccommodationDTO;
import exception.BusinessException;
import model.Accommodation;
import model.Utility;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.AccommodationRepository;

import java.util.List;
import java.util.Optional;


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

        Optional<Accommodation> existingAccommodationOpt = accommodationRepository.findById(accommodationDTO.getId());
        throwExceptionIfAccommodationNotFound(existingAccommodationOpt, accommodationDTO.getId());
        Accommodation existingAccommodation = existingAccommodationOpt.get();

        List<Utility> utilities = accommodationDTO.getUtilities().stream().map(a -> modelMapper.map(a, Utility.class)).toList();
        utilities.forEach(utility -> utility.setAccommodationId(existingAccommodation.getId()));
        existingAccommodation.setUtilities(utilities);

        existingAccommodationOpt.ifPresent(accommodation -> accommodationRepository.save(accommodation));
        return modelMapper.map(existingAccommodationOpt, AccommodationDTO.class);
    }

    public void deleteAccommodation(int accommodationId) throws BusinessException {
        Optional<Accommodation> accommodation = accommodationRepository.findById(accommodationId);
        throwExceptionIfAccommodationNotFound(accommodation, accommodationId);
        accommodationRepository.deleteById(accommodationId);
    }

    public AccommodationDTO getAccommodationDTO(int accommodationId) throws BusinessException {
        return modelMapper.map(getAccommodation(accommodationId), AccommodationDTO.class);
    }

    public Optional<Accommodation> getAccommodation(int accommodationId) throws BusinessException {
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
