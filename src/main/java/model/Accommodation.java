package model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.List;

@Data
@Table(name = "accommodation")
public class Accommodation {

    @Id
    @NotEmpty
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "owners_name")
    private String ownersName;

    @NotEmpty
    @Column(name = "owners_phone_number")
    private String ownersPhoneNumber;

    @NotEmpty
    @Column(name = "owners_email")
    private String email;

    @NotEmpty
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

    @NotEmpty
    @Column(name = "postal_code")
    private Long postalCode;

    @NotEmpty
    @Column(name = "house_number")
    private int houseNumber;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Floor> floors; //TODO ADD TO DATABASE

    @Column(name = "has_internet")
    private boolean hasInternet;

    @Column(name = "has_parking")
    private boolean hasParking;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Utility> utilities; //TODO ADD TO DATABASE

    @Column(name = "rent")
    private float rent;

    @Column(name = "deposit")
    private float deposit;

    @Column(name = "contract_file")
    private File contractFile; // TODO LEARN HOW TO FUCKING DO IT

    @Column(name = "rental_period")
    private int rentalPeriod;

    @Column(name = "notice_period")
    private int noticePeriod;
}
