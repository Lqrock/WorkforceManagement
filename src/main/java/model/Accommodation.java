package model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Data
@Table(name = "accommodation")
public class Accommodation {
    @NotEmpty
    @Column(name = "owners_name")
    private String ownersName;

    @NotEmpty
    @Column(name = "owners_phone_number")
    private String ownersPhoneNumber;

    @NotEmpty
    @Column(name = "owners_email")
    private String email;;

    @NotEmpty
    @Column(name = "owners_type")
    private String ownersType; // what does type refers to? gender?

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
    @Column(name = "postal_code") // PK
    private Long postalCode;

    @NotEmpty
    @Column(name = "house_number")
    private int houseNumber;

    @NotEmpty
    @Column(name = "number_of_floors")
    private int numberOfFloors; // or floor count. --ask--

    @NotEmpty
    @Column(name = "floors")
    private List<String> floors; // --ask--

    @NotEmpty
    @Column(name = "rooms")
    private List<String> rooms; // --ask--

    @NotEmpty
    @Column(name = "bedrooms_per_floor")
    private HashMap<String, Integer> bedroomsPerFloor; // --ask--

    @Column(name = "has_internet")
    private boolean hasInternet;

    @Column(name = "has_parking")
    private boolean hasParking;

    @Column(name = "furniture_and_appliance")
    private List<String> furnitureAndAppliance; // --ask--

    @Column(name = "rent")
    private float rent; // could also be string or double

    @Column(name = "utilities")
    private List<String> utilities; // --ask--

    @Column(name = "deposit")
    private float deposit; // could also be string or double

    @Column(name = "contract_file")
    private File contractFile; // --ask--

    @Column(name = "rental_period")
    private List<LocalDate> rentalPeriod; // --ask--

    @Column(name = "notice_period")
    private List<LocalDate> noticePeriod; // --ask--
}
