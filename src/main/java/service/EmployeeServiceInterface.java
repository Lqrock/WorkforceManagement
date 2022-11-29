package service;

import dto.EmployeeDTO;
import exception.BusinessException;
import model.Employee;

import java.util.Optional;

public interface EmployeeServiceInterface {

    void createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws BusinessException;

    void deleteEmployee(int employeeId) throws BusinessException;

    EmployeeDTO getEmployeeDTO(int employeeId) throws BusinessException;

    Optional<Employee> getEmployee(int employeeId) throws BusinessException;

}
