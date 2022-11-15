package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Table(name = "project")
@Data
public class Project {

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "project_code")
    private int code;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "emails")
    private List<String> emails; // TODO needs fixing

    @NotEmpty
    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "finishing_date")
    private LocalDate finishingDate;

    @Column(name = "maximum_employees_number")
    private int maximumEmployeesNumber;

    private List<String> jobPositions; // TODO

    @JoinColumn(name = "employee_id")
    private Employee employee;
}
