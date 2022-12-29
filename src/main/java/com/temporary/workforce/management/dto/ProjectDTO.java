package com.temporary.workforce.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectDTO {

    private int id;

    private String name;

    private String code;

    private String address;

    private LocalDate startingDate;

    private LocalDate finishingDate;

    private List<PhoneNumberDTO> phoneNumbers;

    private List<EmailDTO> emails;

    private int maximumEmployeesNumber;

    private List<JobPositionDTO> jobPositions;

    private EmployeeDTO employee;
}
