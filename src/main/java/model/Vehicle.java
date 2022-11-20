package model;

import lombok.Cleanup;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "vehicle")
public class Vehicle {

    @NotEmpty
    @Column(name = "model")
    private String model;

    @NotEmpty
    @Column(name = "brand")
    private String brand;

    @NotEmpty
    @Column(name = "plate_number")
    private String plateNumber;

    @NotEmpty
    @Column(name = "vin")
    private Long vin; // TODO change in db - vehicle identification number

    @NotEmpty
    @Column(name = "mileage")
    private int mileage;

    @NotEmpty
    @Column(name = "vehicle_tire_type") // TODO change enums to string in db
    private TireType tireType;

    @NotEmpty
    @Column(name = "insurance_type")
    private String insuranceType;

    @Column(name = "vehicle_dkv_number")
    private DkvNumber dkvNumber;

    @NotEmpty
    @Column(name = "gps_number")
    private String gpsNumber;

    @Column(name = "owners_name") // TODO change from not null in db
    private VehicleOwner ownersName;

    @NotEmpty
    @Column(name = "tuf_expiration_date")
    private LocalDate tufExpirationDate;

    @Column(name = "insurance_expiration_date")
    private LocalDate insuranceExpirationDate;

    @Column(name = "oil_change_indicator")
    private int oilChangeIndicator;

    @Column(name = "fuel_injector_change_indicator") // TODO this was not in the notes, idk why i added it so can be removed
    private int fuelInjectorChangeIndicator; // kilometers left before changing the fuel injector filter

    @Column(name = "timing_belt_change_indicator")
    private int timingBeltChangeIndicator; // kilometers left before changing the timing belt

    @Column(name = "adBlue_change_indicator")
    private int adBlueChangeIndicator;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> driversName;

    @Column(name = "image")
    private List images; // this could be a list of Strings that contains links to images that will later be displayed in the frontend //NID

    @Column(name = "fuel_injector_filter_change_required")
    private boolean fuelInjectorFilterChangeRequired;

    @Column(name = "anti_frost_change_required_change_required")
    private boolean antiFrostChangeRequired;

    @Column(name = "air_filter_change_required")
    private boolean airFilterChangeRequired;

    @Column(name = "inside_air_filter_change_required")
    private boolean insideAirFilterChangeRequired;

    @Column(name = "brake_fluid_change_required")
    private boolean brakeFluidChangeRequired;

    @JoinColumn(name = "project_id")
    private Project project;
}




