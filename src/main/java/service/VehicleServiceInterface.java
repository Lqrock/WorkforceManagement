package service;

import exception.BusinessException;
import dto.VehicleDTO;
import model.Vehicle;

import java.util.Optional;

public interface VehicleServiceInterface {

    void createVehicle(VehicleDTO vehicleDTO);

    VehicleDTO updateVehicle(VehicleDTO vehicleDTO) throws BusinessException;

    void deleteVehicle(int vehicleId) throws BusinessException;

    Optional<Vehicle> getVehicle(int vehicleId) throws BusinessException;

    VehicleDTO getVehicleDTO(int vehicleId) throws BusinessException;
}
