package model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Data
@Table(name = "vehicle")
public class Vehicle {


    Random random = new Random();

    @NotEmpty
    @Column(name = "car_model")
    private String carModel;

    @NotEmpty
    @Column(name = "plate_number")
    private String plateNumber;

    @NotEmpty
    @Column(name = "vehicle_identification_number")
    private Long vehicleIdentificationNumber;

    @NotEmpty
    @Column(name = "vehicle_tire_type")
    private TireType tireType;

    @NotEmpty
    @Column(name = "insurance_type")
    private String insuranceType;

    @NotEmpty
    @Column(name = "gps_number")
    private String gpsNumber;

    @NotEmpty
    @Column(name = "owners_name")
    private String ownerName;

    @NotEmpty
    @Column(name = "tuf_expiration_date")
    private LocalDate tufExpirationDate;

    @Column(name = "insurance_expiration_date")
    private LocalDate insuranceExpirationDate;

    @Column(name = "oil_change_indicator")
    private int oilChangeIndicator; // kilometers left before changing the engine oil

    @Column(name = "fuel_injector_change_indicator")
    private int fuelInjectorChangeIndicator; // kilometers left before changing the fuel injector filter

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> driversName; // read notepad

    @Column(name = "image")
    private List images;

    @Column(name = "fuel_injector_filter_change_required")
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




