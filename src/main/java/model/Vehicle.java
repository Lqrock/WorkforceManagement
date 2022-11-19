package model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "vehicle")
public class Vehicle {

    @NotEmpty
    @Column(name = "car_model")
    private String carModel; // or just model? --ask--

    @NotEmpty
    @Column(name = "plate_number")
    private String plateNumber; // should this be PK?

    @NotEmpty
    @Column(name = "vehicle_identification_number")
    private Long vehicleIdentificationNumber; // should this be called VIN or the full name? current PK

    @NotEmpty
    @Column(name = "mileage")
    private int mileage; // does KM in the notes refers to how many KMs a car travelled? 

    @NotEmpty
    @Column(name = "vehicle_tire_type") // changed the Database name from tire_type to vehicle_tire_type because it had the same name as the Enum tire_type
    private TireType tireType;

    @NotEmpty
    @Column(name = "insurance_type")
    private String insuranceType;

    @Column(name = "vehicle_dkv_number")
    private DkvNumber dkvNumber; // should it be an integer or a string?
    @NotEmpty
    @Column(name = "gps_number")
    private String gpsNumber; // should it be an integer or a string?

    @NotEmpty
    @Column(name = "owners_name") //owners_name or owner_name? also what does "Gil or Disaco or Zarasu" means
    private String ownersName;

    @NotEmpty
    @Column(name = "tuf_expiration_date")
    private LocalDate tufExpirationDate;

    @Column(name = "insurance_expiration_date")
    private LocalDate insuranceExpirationDate;

    @Column(name = "oil_change_indicator")
    private int oilChangeIndicator; // kilometers left before changing the engine oil - could be mandatory

    @Column(name = "fuel_injector_change_indicator") // TODO this was not in the notes, idk why i added it so can be removed
    private int fuelInjectorChangeIndicator; // kilometers left before changing the fuel injector filter

    @Column(name = "timing_belt_change_indicator")
    private int timingBeltChangeIndicator; // kilometers left before changing the timing belt

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> driversName; // this could be retrieved from database by a findAllEmployeesWithDriversLicense method from the repository class //NID

    @Column(name = "image")
    private List images; // this could be a list of Strings that contains links to images that will later be displayed in the frontend //NID

    @Column(name = "fuel_injector_filter_change_required") // it was fuel filter in the notes, are they the same?
    private boolean fuelInjectorFilterChangeRequired; // false means it needs to change. true means it is ok

    @Column(name = "anti_frost_change_required_change_required")
    private boolean antiFrostChangeRequired; // false value means it does not have anti Frost. true means it does

    @Column(name = "air_filter_change_required")
    private boolean airFilterChangeRequired; // false value means a new air filter is required. true means it does not need a new air filter

    @Column(name = "inside_air_filter_change_required")
    private boolean insideAirFilterChangeRequired; // false means a new inside Air filter is required. true means it does not

    @Column(name = "brake_fluid_change_required")
    private boolean brakeFluidChangeRequired; // false means it needs changing. true means it does not

    @JoinColumn(name = "project_id")
    private Project project;
}




