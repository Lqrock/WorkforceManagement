package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.DkvNumber;
import com.temporary.workforce.management.model.TireType;
import com.temporary.workforce.management.model.VehicleOwner;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleDTO {

    private int id;

    private String brand;

    private String model;

    private VehicleOwner ownersName;

    private String plateNumber;

    private Long vin;

    private int mileage;

    private TireType tireType;

    private String insuranceType;

    private DkvNumber dkvNumber;

    private String gpsNumber;

    private String tufExpirationDate;

    private String insuranceExpirationDate;

    private int oilChangeIndicator;

    private int fuelInjectorChangeIndicator;

    private int timingBeltChangeIndicator;

    private int adBlueChangeIndicator;

//    private List images; // TODO LEARN THIS

    private boolean fuelInjectorFilterChangeRequired;

    private boolean antiFrostChangeRequired;

    private boolean airFilterChangeRequired;

    private boolean insideAirFilterChangeRequired;

    private boolean brakeFluidChangeRequired;
}
