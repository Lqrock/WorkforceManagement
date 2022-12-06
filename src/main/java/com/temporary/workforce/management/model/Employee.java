package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @NotEmpty
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @Column(name = "identity_number")
    private int identityNumber;

    @NotEmpty
    @Column(name = "gender")
    private Gender gender;

    @NotEmpty
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @NotEmpty
    @Column(name = "nationality")
    private String nationality;

    @NotEmpty
    @Column(name = "citizenship_country")
    private String citizenshipCountry;

    @NotEmpty
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotEmpty
    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Column(name = "bank_name")
    private String bankName;

    @NotEmpty
    @Column(name = "bank_account_number")
    private Long bankAccountNumber;

    @NotEmpty
    @Column(name = "has_drivers_license")
    private boolean hasDriversLicense;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Language> spokenLanguages;

    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @NotEmpty
    @Column(name = "starting_date")
    private LocalDate startingDate;

    @NotEmpty
    @Column(name = "finishing_date")
    private LocalDate finishingDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Project> projects;

    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    @Column(name = "contract_file")
    private File contractFile;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @NotEmpty
    @Column(name = "contract_type")
    private String contractType;

    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
