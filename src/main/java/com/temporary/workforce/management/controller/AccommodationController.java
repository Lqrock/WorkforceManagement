package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.temporary.workforce.management.service.AccommodationService;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController {

    @Autowired
    AccommodationService accommodationService;

    @PostMapping("/create")
    public ResponseEntity createAccommodation(@RequestBody AccommodationDTO accommodationDTO){
        accommodationService.createAccommodation(accommodationDTO);
        return new ResponseEntity("\nCreated", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateAccommodation(@RequestBody AccommodationDTO accommodationDTO) throws BusinessException {
        accommodationService.updateAccommodation(accommodationDTO);
        return new ResponseEntity("\nUpdated", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteAccommodation(@RequestParam int accommodationId) throws BusinessException{
        accommodationService.deleteAccommodation(accommodationId);
        return new ResponseEntity("\nDeleted", HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity getAccommodation(@RequestParam int accommodationId) throws BusinessException{
        accommodationService.getAccommodation(accommodationId);
        return new ResponseEntity(accommodationService.getAccommodation(accommodationId) +
                "\nRetrieved", HttpStatus.OK);
    }

    @GetMapping("/getdto")
    public ResponseEntity getAccommodationDTO(@RequestParam int accommodationId) throws BusinessException{
        accommodationService.getAccommodationDTO(accommodationId);
        return new ResponseEntity(accommodationService.getAccommodationDTO(accommodationId) +
                "\nRetrieved", HttpStatus.OK);
    }

}
