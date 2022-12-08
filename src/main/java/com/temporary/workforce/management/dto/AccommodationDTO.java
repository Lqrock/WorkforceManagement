package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.OwnershipType;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class AccommodationDTO {

    private int id;

    private String ownersName;

    private String ownersPhoneNumber;

    private String email;

    private OwnershipType ownershipType;

    private Long ownersBankAccount;

    private String province;

    private String city;

    private String address;

    private Long postalCode;

    private int houseNumber;

    private List<FloorDTO> floors;

    private boolean hasInternet;

    private boolean hasParking;

    private List<String> utilities;

    private float rent;

    private float deposit;

//    private File contractFile; TODO learn

    private int rentalPeriod;

    private int noticePeriod;
}
