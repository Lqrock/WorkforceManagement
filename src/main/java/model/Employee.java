package model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "employee")
public class Employee {

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName; // this was not in the notes. added it anyway

    @NotEmpty
    @Column(name = "identity_number")
    private int identityNumber; // it was identity code in notes. this is also the PK

    @NotEmpty
    @Column(name = "employee_gender")
    private Gender gender;

    @NotEmpty
    @Column(name = "employee_marital_status")
    private MaritalStatus maritalStatus;

    @NotEmpty
    @Column(name = "nationality")
    private String nationality; // could also be an Enum list of countries to avoid false entries 1

    @NotEmpty
    @Column(name = "citizenship_country")
    private String citizenshipCountry; // could be an enum list to avoid false entries 2

    @NotEmpty
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotEmpty
    @Column(name = "place_of_birth")
    private String placeOfBirth; // could be an enum list to avoid false entries 3

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
    private List<Language> spokenLanguages; // TODO should be a list of values from Enum Language

    @Column(name = "employee_job_position")
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
    private List<Vehicle> vehicles; // -- ask --// was not in the notes // NID

    @Column(name = "contract_file")
    private File contractFile;

    @Column(name = "salary_per_hour")
    private double salaryPerHour; // can also be Float

    @NotEmpty
    @Column(name = "contract_type")
    private String contractType; // could also be enum // also what is "Gil or Disaco or Zarasu"?

    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
