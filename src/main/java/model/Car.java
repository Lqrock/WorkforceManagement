package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "vehicles")
public class Car {
    // @NotNull = null not allowed but "" is allowed.
    // @NotEmpty = null not allowed and "" also not allowed but spaces are counted characters so " " is allowed
    // @NotBlank (for strings) = null not allowed and trimmed length has to be greater than 0 ( no spaces )

    @NotEmpty
    @Column(name = "car_model")
    private String carModel;
    @NotEmpty
    @Column(name = "plate_number")
    private String plateNumber;
    @NotEmpty
    @Column(name = "vehicle_indentification_number")
    private String vehicleIdentificationNumber;
    @NotEmpty
    @Column(name = "tuf_expiration_date")
    private LocalDate tufExpirationDate;
    @NotEmpty
    @Column(name = "insurance_type")
    private String insuranceType;
    @NotEmpty
    @Column(name = "gps_number")
    private String gpsNumber;
    @NotEmpty
    @Column(name = "owners_name")
    private String ownerName;

    @Column(name = "insurance_expiration_date")
    private LocalDate insuranceExpirationDate;

    @Column(name = "oil_change_indicator")
    private int oilChange; // kilometers left before changing the engine oil
    @Column(name = "fuel_injector_change_indicator")
    private int fuelInjectorChange; // kilometers left before changing the fuel injector filter

    @NotEmpty
    @Column(name = "list_of_drivers")
    private List<Employee> driversName;
    @Column(name = "list_of_car_images")
    private List images;

    @Column(name = "fuel_injector_filter_status")
    private boolean fuelInjectorFilter; // false means it needs to change. true means it is ok
    @Column(name = "anti_frost_status")
    private boolean antiFrost; // false value means it does not have anti Frost. true means it does
    @Column(name = "air_filter_status")
    private boolean airFilter; // false value means a new air filter is required. true means it does not need a new air filter
    @Column(name = "inside_air_filter_status")
    private boolean insideAirFilter; // false means a new inside Air filter is required. true means it does not
    @Column(name = "brake_fluid_status")
    private boolean brakeFluid; // false means it needs changing. true means it does not


    }




