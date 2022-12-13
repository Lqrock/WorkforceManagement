package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.*;
import lombok.Data;

import java.io.File;
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

    private List<ProjectDTO> projectDTOS;

    private AccommodationDTO accommodationDTO;

    private List<VehicleDTO> vehicleDTOS;

//    private File contractFile;

    private double salaryPerHour;

    private String contractType;

    private VehicleDTO vehicleDTO;

    private List<LanguageDTO> spokenLanguages; //
}
