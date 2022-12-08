package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;

@Data
@Entity
@Table(name = "accommodation")
public class Accommodation {

    @Id
    @Column(name = "id")
    private int id;

    @NotEmpty
    @Column(name = "owners_name")
    private String ownersName;

    @NotEmpty
    @Column(name = "owners_phone_number")
    private String ownersPhoneNumber;

    @NotEmpty
    @Column(name = "owners_email")
    private String email;

    @NotNull
    @Column(name = "ownership_type")
    private OwnershipType ownershipType;

    @Column(name = "owners_bank_account")
    private Long ownersBankAccount;

    @NotEmpty
    @Column(name = "province")
    private String province;

    @NotEmpty
    @Column(name = "city")
    private String city;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "postal_code")
    private Long postalCode;

    @NotNull
    @Column(name = "house_number")
    private int houseNumber;

    //@NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Floor> floors;

    @Column(name = "has_internet")
    private boolean hasInternet;

    @Column(name = "has_parking")
    private boolean hasParking;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Utility> utilities;

    @Column(name = "rent")
    private float rent;

    @Column(name = "deposit")
    private float deposit;

//    @Column(name = "contract_file")
//    private File contractFile; TODO

    @Column(name = "rental_period")
    private int rentalPeriod;

    @Column(name = "notice_period")
    private int noticePeriod;
}
