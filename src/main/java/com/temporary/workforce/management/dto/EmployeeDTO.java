package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.Gender;
import com.temporary.workforce.management.model.MaritalStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeeDTO {

    private int id;

    private String firstName;

    private String lastName;

    private int identityNumber;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private String nationality;

    private String citizenshipCountry;

    private LocalDate dateOfBirth;

    private String placeOfBirth;

    private String address;

    private String phoneNumber;

    private String email;

    private String bankName;

    private Long bankAccountNumber;

    private boolean hasDriversLicense;

    private Integer jobPositionId;

    private LocalDate startingDate;

    private LocalDate finishingDate;

    private List<ProjectDTO> projects;

    private AccommodationDTO accommodation;

    private List<VehicleDTO> vehicles;

//    private File contractFile;

    private double salaryPerHour;

    private String contractType;

    private VehicleDTO vehicle;

    private List<LanguageDTO> spokenLanguages; //
}
