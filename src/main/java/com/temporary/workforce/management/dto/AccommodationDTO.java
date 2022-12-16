package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.OwnershipTypeEnum;
import lombok.Data;

import java.util.List;

@Data
public class AccommodationDTO {

    private int id;

    private String ownersName;

    private String ownersPhoneNumber;

    private String email;

    private OwnershipTypeEnum ownershipType;

    private Long ownersBankAccount;

    private String province;

    private String city;

    private String address;

    private Long postalCode;

    private int houseNumber;

    private List<FloorDTO> floors;

    private boolean hasInternet;

    private boolean hasParking;

    private List<UtilityDTO> utilities;

    private float rent;

    private float deposit;

//    private File contractFile; TODO learn

    private int rentalPeriod;

    private int noticePeriod;
}
