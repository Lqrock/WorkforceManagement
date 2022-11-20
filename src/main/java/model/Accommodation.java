package model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.List;

@Data
@Table(name = "accommodation")
public class Accommodation {
    @NotEmpty
    @Column(name = "owners_name")
    private String ownersName; //TODO change to owner_name

    @NotEmpty
    @Column(name = "owners_phone_number")
    private String ownersPhoneNumber;

    @NotEmpty
    @Column(name = "owners_email")
    private String email;

    @NotEmpty
    @Column(name = "owners_type")
    private String ownersType; // TODO enum, (legal, natural)

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

    @NotEmpty
    @Column(name = "postal_code") // this is the current PK
    private Long postalCode;

    @NotEmpty
    @Column(name = "house_number")
    private int houseNumber; // does it also include letters? or only numbers

    @NotEmpty
    @Column(name = "number_of_floors")
    private int numberOfFloors; // TODO delete from db

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Floor> floors; //TODO nid

    @Column(name = "has_internet")
    private boolean hasInternet;

    @Column(name = "has_parking")
    private boolean hasParking;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Utility> utilities; //TODO NID

    @Column(name = "rent")
    private float rent;

    @Column(name = "deposit")
    private float deposit;

    @Column(name = "contract_file")
    private File contractFile; //NID

    @Column(name = "rental_period")
    private int rentalPeriod; // TODO change in db

    @Column(name = "notice_period")
    private int noticePeriod;// NID
}
