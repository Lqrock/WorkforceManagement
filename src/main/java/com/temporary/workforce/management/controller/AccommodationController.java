package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Accommodation;
import com.temporary.workforce.management.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/accommodation")
public class AccommodationController {

    @Autowired
    AccommodationService accommodationService;

    @PostMapping("/create")
    public ResponseEntity<AccommodationDTO> createAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        accommodationService.createAccommodation(accommodationDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<AccommodationDTO> updateAccommodation(@RequestBody AccommodationDTO accommodationDTO) throws BusinessException {
        accommodationService.updateAccommodation(accommodationDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{accommodationId}")
//    public ResponseEntity<AccommodationDTO> deleteAccommodation(@PathVariable int accommodationId) throws BusinessException {
//        accommodationService.deleteAccommodation(accommodationId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/get/{accommodationId}")
    public ResponseEntity<AccommodationDTO> getAccommodation(@PathVariable int accommodationId) throws BusinessException {
        return new ResponseEntity<>(accommodationService.getAccommodationDTO(accommodationId), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public String showAllAccommodations(Model model) {
        List<AccommodationDTO> accommodationDTOList = accommodationService.getAllAccommodations();
        model.addAttribute("accommodations", accommodationDTOList);
        return "show-all-accommodations";
    }

    @GetMapping("/register")
    public String showAccommodationForm(Model model) {
        AccommodationDTO accommodationDTO = new AccommodationDTO();
        model.addAttribute("accommodation", accommodationDTO);
        return "create-accommodation";
    }

    @PostMapping("/register")
    public String registerAccommodation(Model model, @ModelAttribute("accommodation") AccommodationDTO accommodationDTO) {
        accommodationService.createAccommodation(accommodationDTO);
        List<AccommodationDTO> accommodationDTOList = accommodationService.getAllAccommodations();
        model.addAttribute("accommodations", accommodationDTOList);
        return "show-all-accommodations";
    }

    @GetMapping("/delete/{accommodationId}")
    public String deleteVehicle(@PathVariable int accommodationId) throws BusinessException {
        accommodationService.deleteAccommodation(accommodationId);
        return "redirect:/accommodation/get-all";
    }
}
