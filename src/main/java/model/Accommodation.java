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
    @Column(name = "owners_name") //owners_name or owner_name?
    private String ownersName;

    @NotEmpty
    @Column(name = "owners_phone_number")
    private String ownersPhoneNumber;

    @NotEmpty
    @Column(name = "owners_email")
    private String email;

    @NotEmpty
    @Column(name = "owners_type")
    private String ownersType; // what does type refers to?

    @Column(name = "owners_bank_account") // what is the default value?null?
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
    private int numberOfFloors; // or floor count. --ask--

    @NotEmpty
    @Column(name = "floors")
    private List<String> floors; // --ask-- // also this could be a string, and another List<String> floors can exist which retrieve different accommodation's floor count //NID

    @NotEmpty
    @Column(name = "rooms")
    private List<String> rooms; // --ask-- // same as above //NID

    @NotEmpty
    @Column(name = "bedrooms_per_floor")
    private HashMap<String, Integer> bedroomsPerFloor; // --ask-- // if values are fixed, such as 2 per floor, 4 per floor, it could be a normal String //NID

    @Column(name = "has_internet")
    private boolean hasInternet;

    @Column(name = "has_parking")
    private boolean hasParking;

    @Column(name = "furniture_and_appliance")
    private List<String> furnitureAndAppliance; // --ask-- // will need another table for this. //NID

    @Column(name = "rent")
    private float rent; // could also be string or double

    @Column(name = "utilities")
    private List<String> utilities; // --ask-- // can be a string or will need another table for this //NID

    @Column(name = "deposit")
    private float deposit; // could also be string or double

    @Column(name = "contract_file")
    private File contractFile; // --ask-- //NID

    @Column(name = "rental_period")
    private List<LocalDate> rentalPeriod; // --ask-- does period refer to a List? or a simple date //NID

    @Column(name = "notice_period")
    private List<LocalDate> noticePeriod; // --ask-- //NID
}
