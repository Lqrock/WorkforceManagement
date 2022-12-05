package service;

import exception.BusinessException;
import org.springframework.stereotype.Service;
import repository.VehicleRepository;
import dto.VehicleDTO;
import model.Employee;
import model.Vehicle;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements VehicleServiceInterface{

    @Autowired
    VehicleRepository vehicleRepository;

    Logger logger = LoggerFactory.getLogger(VehicleService.class);

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void createVehicle(VehicleDTO vehicleDTO) {
        logger.info("Creating vehicle");
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        vehicleRepository.save(vehicle);
        logger.info("Vehicle created");
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) throws BusinessException {

        logger.info("Updating vehicle " + vehicleDTO.getId());
        Optional<Vehicle> existingVehicleOpt = vehicleRepository.findById(vehicleDTO.getId());
        throwExceptionIfVehicleNotFound(existingVehicleOpt, vehicleDTO.getId());
        Vehicle existingVehicle = existingVehicleOpt.get();

        existingVehicle.setModel(vehicleDTO.getModel());
        existingVehicle.setBrand(vehicleDTO.getBrand());
        existingVehicle.setPlateNumber(vehicleDTO.getPlateNumber());
        existingVehicle.setVin(vehicleDTO.getVin());
        existingVehicle.setMileage(vehicleDTO.getMileage());
        existingVehicle.setTireType(vehicleDTO.getTireType());
        existingVehicle.setInsuranceType(vehicleDTO.getInsuranceType());
        existingVehicle.setDkvNumber(vehicleDTO.getDkvNumber());
        existingVehicle.setGpsNumber(vehicleDTO.getGpsNumber());
        existingVehicle.setOwnersName(vehicleDTO.getOwnersName());
        existingVehicle.setTufExpirationDate(vehicleDTO.getTufExpirationDate());
        existingVehicle.setInsuranceExpirationDate(vehicleDTO.getInsuranceExpirationDate());
        existingVehicle.setOilChangeIndicator(vehicleDTO.getOilChangeIndicator());
        existingVehicle.setFuelInjectorChangeIndicator(vehicleDTO.getFuelInjectorChangeIndicator());
        existingVehicle.setTimingBeltChangeIndicator(vehicleDTO.getTimingBeltChangeIndicator());
        existingVehicle.setAdBlueChangeIndicator(vehicleDTO.getAdBlueChangeIndicator());
        existingVehicle.setFuelInjectorFilterChangeRequired(vehicleDTO.isFuelInjectorFilterChangeRequired());
        existingVehicle.setAntiFrostChangeRequired(vehicleDTO.isAntiFrostChangeRequired());
        existingVehicle.setAirFilterChangeRequired(vehicleDTO.isAirFilterChangeRequired());
        existingVehicle.setInsideAirFilterChangeRequired(vehicleDTO.isInsideAirFilterChangeRequired());
        existingVehicle.setBrakeFluidChangeRequired(vehicleDTO.isBrakeFluidChangeRequired());
        existingVehicle.setProjectId(vehicleDTO.getProject());
        existingVehicle.setEmployeeId(vehicleDTO.getEmployeeId());

        List<Employee> driversNames = vehicleDTO.getDriversNameDTO().stream()
                .map(a -> modelMapper.map(a, Employee.class)).toList();

        driversNames.forEach(driver -> driver.setVehicle(existingVehicle));
        existingVehicle.setDriversName(driversNames);
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

    void throwExceptionIfVehicleNotFound(Optional<Vehicle> vehicle, int vehicleId) throws BusinessException{
        if(vehicle.isEmpty()){
            throw new BusinessException("Vehicle with ID " + vehicleId + " not found");
        }
    }
}
