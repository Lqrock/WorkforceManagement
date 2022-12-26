package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/create")
    public ResponseEntity createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO vehicleDTO) throws BusinessException {
        vehicleService.updateVehicle(vehicleDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{vehicleId}")
    public ResponseEntity deleteVehicle(@PathVariable int vehicleId) throws BusinessException {
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get/{vehicleId}")
    public ResponseEntity getVehicle(@PathVariable int vehicleId) throws BusinessException {
        return new ResponseEntity(vehicleService.getVehicleDTO(vehicleId), HttpStatus.OK);
    }
}
