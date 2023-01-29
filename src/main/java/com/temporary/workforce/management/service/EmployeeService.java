package com.temporary.workforce.management.service;

import com.temporary.workforce.management.dto.EmployeeDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.model.*;
import com.temporary.workforce.management.repository.EmployeeRepository;
import com.temporary.workforce.management.repository.JobPositionRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    JobPositionRepository jobPositionRepository;

    ModelMapper modelMapper = new ModelMapper();

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        logger.info("Starting employee creation");
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        if (!employeeDTO.getSpokenLanguages().isEmpty()) {
            employee.getSpokenLanguages().forEach(language -> language.setEmployee(employee));
        }
//        if (!employee.getProjects().isEmpty()) {
//            employee.getProjects().forEach(project -> project.setEmployee(employee));
//            employee.getProjects().forEach(project -> project.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setProject(project)));
//            employee.getProjects().forEach(project -> project.getEmails().forEach(email -> email.setProject(project)));
//        }
        if (employee.getVehicle() != null) {
            employee.getVehicle().setEmployee(employee);
            if (employee.getVehicle().getProjectId() != null) {
                employee.getVehicle().getProjectId().setEmployee(employee);
            }
        }
        if (!employee.getTimeSheetList().isEmpty()) {
            employee.getTimeSheetList().forEach(timeSheet -> timeSheet.setEmployee(employee));
        }
        if (employee.getAccommodation() != null) {
            employee.getAccommodation().getFloors().forEach(floor -> floor.setAccommodation(employee.getAccommodation()));
            employee.getAccommodation().getUtilities().forEach(utility -> utility.setAccommodation(employee.getAccommodation()));
            employee.getAccommodation().getFloors().forEach(floor -> floor.getRooms().forEach(room -> room.setFloor(floor)));
        }


        employeeRepository.save(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws BusinessException {

        logger.info("Updating employee {}", employeeDTO.getId());
        Optional<Employee> existingEmployeeOpt = employeeRepository.findById(employeeDTO.getId());
        throwExceptionIfEmployeeNotFound(existingEmployeeOpt, employeeDTO.getId());
        Employee existingEmployee = modelMapper.map(employeeDTO, Employee.class);

        if (!existingEmployee.getSpokenLanguages().isEmpty()) {
            existingEmployee.getSpokenLanguages().forEach(language -> language.setEmployee(existingEmployee));
        }
        if (!existingEmployee.getTimeSheetList().isEmpty()) {
            existingEmployee.getTimeSheetList().forEach(timeSheet -> timeSheet.setEmployee(existingEmployee));
        }
        if (existingEmployee.getVehicle() != null) {
            existingEmployee.getVehicle().setEmployee(existingEmployee);
        }
        if (existingEmployee.getAccommodation() != null) {
            if (!existingEmployee.getAccommodation().getFloors().isEmpty()) {
                existingEmployee.getAccommodation().getFloors().forEach(floor -> floor.setAccommodation(existingEmployee.getAccommodation()));
                existingEmployee.getAccommodation().getFloors().forEach(floor -> floor.getRooms().forEach(room -> room.setFloor(floor)));
            }
            if (!existingEmployee.getAccommodation().getUtilities().isEmpty()) {
                existingEmployee.getAccommodation().getUtilities().forEach(utility -> utility.setAccommodation(existingEmployee.getAccommodation()));
            }
        }
        if (!existingEmployee.getProjects().isEmpty()) {
            existingEmployee.getProjects().forEach(project -> project.setEmployee(existingEmployee));
//            existingEmployee.getProjects().forEach(project -> project.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setProject(project)));
            existingEmployee.getProjects().forEach(project -> project.getEmails().forEach(email -> email.setProject(project)));
        }


        employeeRepository.save(existingEmployee);
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

    @Override
    public List<EmployeeDTO> getAllAccommodations() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        if (!employees.isEmpty()) {
            employees.forEach(employee -> employeeDTOList.add(modelMapper.map(employee, EmployeeDTO.class)));
        }
        return employeeDTOList;
    }

    public void throwExceptionIfEmployeeNotFound(Optional<Employee> employee, int employeeId) throws BusinessException {
        if (employee.isEmpty()) {
            throw new BusinessException("Employee with ID " + employeeId + " not found");
        }
    }

}
