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
    private int id;

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
    private List<PhoneNumbers> phoneNumber;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Email> emails;

    @NotEmpty
    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "finishing_date")
    private LocalDate finishingDate;

    @Column(name = "maximum_employees_number")
    private int maximumEmployeesNumber;

    @OneToMany(fetch = FetchType.LAZY)
    private List<String> jobPositions;

    @JoinColumn(name = "employee_id")
    private Employee employee;
}
