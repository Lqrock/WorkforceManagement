package controller;

import dto.AccommodationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AccommodationService;

@RequestMapping("/accommodation")
public class AccommodationController {

    @Autowired
    AccommodationService accommodationService;

    @PostMapping("/create")
    public ResponseEntity createAccommodation(@RequestBody AccommodationDTO accommodationDTO){
        accommodationService.createAccommodation(accommodationDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }



}
