package model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "project")
public class Project {

    @Id
    @NotEmpty
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "code")
    private String code;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<PhoneNumber> phoneNumber;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Email> emails; // TODO - Create table

    @NotEmpty
    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "finishing_date")
    private LocalDate finishingDate;

    @Column(name = "maximum_employees_number")
    private int maximumEmployeesNumber;

    private List<String> jobPositions; // TODO - Create table

    @JoinColumn(name = "employee_id")
    private Employee employee;
}
