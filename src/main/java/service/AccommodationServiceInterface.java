package service;

import dto.AccommodationDTO;
import exception.BusinessException;
import model.Accommodation;

import java.util.Optional;

public interface AccommodationServiceInterface {

    void createAccommodation(AccommodationDTO accommodationDTO);

    AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO) throws BusinessException;

    void deleteAccommodation(int accommodationId) throws BusinessException;

    Optional<Accommodation> getAccommodation(int accommodationId) throws BusinessException;

    AccommodationDTO getAccommodationDTO(int accommodationId) throws BusinessException;
}
