package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.AccommodationDTO;
import com.temporary.workforce.management.dto.VehicleDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.Accommodation;
import com.temporary.workforce.management.model.Vehicle;
import com.temporary.workforce.management.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements VehicleServiceInterface {

    @Autowired
    VehicleRepository vehicleRepository;

    Logger logger = LoggerFactory.getLogger(VehicleService.class);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createVehicle(VehicleDTO vehicleDTO) {
        logger.info("Creating vehicle");
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        vehicle.setInsuranceExpirationDate(LocalDate.parse(vehicleDTO.getInsuranceExpirationDate(), formatter));
        vehicle.setTufExpirationDate(LocalDate.parse(vehicleDTO.getTufExpirationDate(), formatter));
        vehicleRepository.save(vehicle);
        logger.info("Vehicle created");
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) throws BusinessException {

        logger.info("Updating vehicle {}", vehicleDTO.getId());
        Optional<Vehicle> existingVehicleOpt = vehicleRepository.findById(vehicleDTO.getId());
        throwExceptionIfVehicleNotFound(existingVehicleOpt, vehicleDTO.getId());
        Vehicle existingVehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        if (existingVehicleOpt.isPresent() && existingVehicleOpt.get().getEmployee() != null) {
            existingVehicle.setEmployee(existingVehicleOpt.get().getEmployee());
        }
        if (existingVehicleOpt.isPresent() && existingVehicleOpt.get().getProjectId() != null) {
            existingVehicle.setProjectId(existingVehicleOpt.get().getProjectId());
        }
        vehicleRepository.save(existingVehicle);
        logger.info("Vehicle updated");
        return modelMapper.map(existingVehicle, VehicleDTO.class);
    }

    @Override
    public void deleteVehicle(int vehicleId) throws BusinessException {
        logger.info("Deleting vehicle");
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        throwExceptionIfVehicleNotFound(vehicle, vehicleId);
        vehicleRepository.deleteById(vehicleId);
        logger.info("Vehicle deleted");
    }

    @Override
    public Optional<Vehicle> getVehicle(int vehicleId) throws BusinessException {
        logger.info("Retrieving vehicle");
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        throwExceptionIfVehicleNotFound(vehicle, vehicleId);
        return vehicle;
    }

    @Override
    public VehicleDTO getVehicleDTO(int vehicleId) throws BusinessException {
        logger.info("Retrieving vehicleDTO");
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        throwExceptionIfVehicleNotFound(vehicle, vehicleId);
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        vehicles.forEach(vehicle -> vehicleDTOList.add(modelMapper.map(vehicle, VehicleDTO.class)));
        return vehicleDTOList;
    }

    @Override
    public List<VehicleDTO> getAllAccommodations() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleDTO> vehicleDTOList = new ArrayList<>();
        if (!vehicles.isEmpty()) {
            vehicles.forEach(vehicle -> vehicleDTOList.add(modelMapper.map(vehicle, VehicleDTO.class)));
        }
        return vehicleDTOList;
    }

    void throwExceptionIfVehicleNotFound(Optional<Vehicle> vehicle, int vehicleId) throws BusinessException {
        if (vehicle.isEmpty()) {
            throw new BusinessException("Vehicle with ID " + vehicleId + " not found");
        }
    }
}
