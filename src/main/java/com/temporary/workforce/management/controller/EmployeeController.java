package com.temporary.workforce.management.controller;

import com.temporary.workforce.management.dto.EmployeeDTO;
import com.temporary.workforce.management.exception.BusinessException;
import com.temporary.workforce.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO) throws BusinessException {
        employeeService.updateEmployee(employeeDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteEmployee(@RequestParam int employeeId) throws BusinessException {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity getEmployee(@RequestParam int employeeId) throws BusinessException {
        employeeService.getEmployee(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/getDTO")
    public ResponseEntity getEmployeeDTO(@RequestParam int employeeId) throws BusinessException {
        employeeService.getEmployeeDTO(employeeId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
