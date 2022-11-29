package service;

import dto.EmployeeDTO;
import exception.BusinessException;
import model.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements EmployeeServiceInterface{

    @Autowired
    EmployeeRepository employeeRepository;

    ModelMapper modelMapper = new ModelMapper();

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        logger.info("Starting employee creation");
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employeeRepository.save(employee);
        logger.info("Employee created successfully");
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws BusinessException {

        logger.info("Updating employee " + employeeDTO.getId());
        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(employeeDTO.getId());
        throwExceptionIfEmployeeNotFound(existingEmployeeOpt, employeeDTO.getId());
        Employee existingEmployee = existingEmployeeOpt.get();

        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setIdentityNumber(employeeDTO.getIdentityNumber());
        existingEmployee.setGender(employeeDTO.getGender());
        existingEmployee.setMaritalStatus(employeeDTO.getMaritalStatus());
        existingEmployee.setNationality(employeeDTO.getNationality());
        existingEmployee.setCitizenshipCountry(employeeDTO.getCitizenshipCountry());
        existingEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        existingEmployee.setPlaceOfBirth(employeeDTO.getPlaceOfBirth());
        existingEmployee.setAddress(employeeDTO.getAddress());
        existingEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setBankName(employeeDTO.getBankName());
        existingEmployee.setBankAccountNumber(employeeDTO.getBankAccountNumber());
        existingEmployee.setHasDriversLicense(employeeDTO.isHasDriversLicense());
        existingEmployee.setJobPosition(employeeDTO.getJobPosition());
        existingEmployee.setStartingDate(employeeDTO.getStartingDate());
        existingEmployee.setFinishingDate(employeeDTO.getFinishingDate());
        existingEmployee.setAccommodation(modelMapper.map(employeeDTO.getAccommodationDTO(), Accommodation.class));
        existingEmployee.setContractFile(employeeDTO.getContractFile());
        existingEmployee.setSalaryPerHour(employeeDTO.getSalaryPerHour());
        existingEmployee.setContractType(employeeDTO.getContractType());
        existingEmployee.setVehicle(modelMapper.map(employeeDTO.getVehicleDTO(), Vehicle.class));

        List<Language> languages = employeeDTO.getSpokenLanguages().stream()
                .map(a -> modelMapper.map(a, Language.class)).toList();
        languages.forEach(language -> language.setEmployeeIdd(existingEmployee.getId()));
        existingEmployee.setSpokenLanguages(languages);

        List<Project> projects = employeeDTO.getProjectDTOS().stream()
                .map(a -> modelMapper.map(a, Project.class)).toList();
        projects.forEach(project -> project.setEmployee(existingEmployee)); // this could be int instead of employee
        existingEmployee.setProjects(projects);

        List<Vehicle> vehicles = employeeDTO.getVehicleDTOS().stream()
                .map(a -> modelMapper.map(a, Vehicle.class)).toList();
        vehicles.forEach(vehicle -> vehicle.setEmployee_id(existingEmployee.getId()));
        existingEmployee.setVehicles(vehicles);

        employeeRepository.save(existingEmployee);
        logger.info("Employee updated");
        return modelMapper.map(existingEmployee, EmployeeDTO.class);
    }

    @Override
    public void deleteEmployee(int employeeId) throws BusinessException {
        logger.info("Deleting employee");
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        throwExceptionIfEmployeeNotFound(employee, employeeId);
        employeeRepository.deleteById(employeeId);
        logger.info("Employee deleted");
    }

    @Override
    public EmployeeDTO getEmployeeDTO(int employeeId) throws BusinessException {
        logger.info("Retrieving employeeDTO");
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        throwExceptionIfEmployeeNotFound(employee, employeeId);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    @Override
    public Optional<Employee> getEmployee(int employeeId) throws BusinessException {
        logger.info("Retrieving employee");
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        throwExceptionIfEmployeeNotFound(employee, employeeId);
        return employee;
    }

    public void throwExceptionIfEmployeeNotFound(Optional<Employee> employee, int employeeId) throws BusinessException{
        if(employee.isEmpty()){
            throw new BusinessException("Employee with ID " + employeeId + " not found");
        }
    }

}