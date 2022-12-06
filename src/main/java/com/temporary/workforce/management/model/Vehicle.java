package com.temporary.workforce.management.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @NotEmpty
    @Column(name = "id")
    private int id;

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
    private Long vin;

    @NotEmpty
    @Column(name = "mileage")
    private int mileage;

    @NotEmpty
    @Column(name = "tire_type")
    private TireType tireType;

    @NotEmpty
    @Column(name = "insurance_type")
    private String insuranceType;

    @Column(name = "dkv_number")
    private DkvNumber dkvNumber;

    @NotEmpty
    @Column(name = "gps_number")
    private String gpsNumber;

    @Column(name = "owners_name")
    private VehicleOwner ownersName;

    @NotEmpty
    @Column(name = "tuf_expiration_date")
    private LocalDate tufExpirationDate;

    @Column(name = "insurance_expiration_date")
    private LocalDate insuranceExpirationDate;

    @Column(name = "oil_change_indicator")
    private int oilChangeIndicator;

    @Column(name = "fuel_injector_change_indicator")
    private int fuelInjectorChangeIndicator;

    @Column(name = "timing_belt_change_indicator")
    private int timingBeltChangeIndicator;

    @Column(name = "adBlue_change_indicator")
    private int adBlueChangeIndicator;

    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> driversName;

//    @Column(name = "image")
//    private List images; // TODO LEARN THIS

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
    private int projectId;

    @JoinColumn(name = "employee_id")
    private int employeeId;
}




