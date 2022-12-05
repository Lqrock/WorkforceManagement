package dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectDTO {

    private int id;

    private String name;

    private String code;

    private String address;

    private List<String> phoneNumber;

    private List<String> emails;

    private LocalDate startingDate;

    private LocalDate finishingDate;

    private int maximumEmployeesNumber;

    private List<JobPositionDTO> jobPositionDTOS;

    private EmployeeDTO employeeDTO;
}
