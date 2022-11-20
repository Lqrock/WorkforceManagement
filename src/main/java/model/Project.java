package model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "project")
public class Project {

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "code")
    private String code; // TODO change column name in db

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<PhoneNumber> phoneNumber; // singular phone number or a list?

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Email> emails; // TODO fix in db

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
