package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "employee")
@Data
public class Employee {

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty
    @Column(name = "social_id")
    private String socialId; // or identity code/social security number/sozialversicherungsausweis!!!!
    @NotEmpty
    @Column(name = "gender")
    private String gender; // could be an enum
    @NotEmpty
    @Column(name = "marital_status")
    private String maritalStatus; // could be an enum
    @NotEmpty
    @Column(name = "nationality")
    private String nationality;
    @NotEmpty
    @Column(name = "citizenship_country")
    private String citizenshipCountry;
    @NotEmpty
    @Column(name = "Date_of_birth")
    private LocalDate dateOfBirth;
    @NotEmpty
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @NotEmpty
    @Column(name = "address")
    private String address;
    @NotEmpty
    @Column(name = "phone_number")
    private String phoneNumber; // there should also be a list of phone number prefixes, like +98
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
    @Column(name = "drivers_license_status")
    private boolean hasDriversLicense;
    @NotEmpty
    @Column(name = "list_of_spoken_languages")
    private List<String> spokenLanguages = new ArrayList<>(); // ask
    @NotEmpty
    @Column(name = "starting_day")
    private LocalDate startingDay;
    @NotEmpty
    @Column(name = "finishing_day")
    private LocalDate finishingDay;
    @Column(name = "list_of_projects")
    private List<Project> projectsList;
    @Column(name = "accommodation")
    private Accommodation accommodation;
    @Column(name = "cars")
    private List<Vehicle> cars;
    @Column(name = "contract_file")
    private File contractFile;
    @Column(name = "salary_per_hour")
    private double salaryPerHour;
    @NotEmpty
    @Column(name = "contract_type")
    private String contractType; // could also be enum


















}
