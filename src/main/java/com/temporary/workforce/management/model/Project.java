package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "project_job_position", joinColumns = {@JoinColumn(name = "project_id")}, inverseJoinColumns = {@JoinColumn(name = "job_position_id")})
    private List<JobPosition> jobPositions;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
