package service;

import dto.AccommodationDTO;
import exception.BusinessException;

public interface AccommodationServiceInterface {
    void createAccommodation(AccommodationDTO accommodationDTO);

    AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO) throws BusinessException;


}
