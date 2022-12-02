package dto;

import lombok.Data;
import model.DkvNumber;
import model.Employee;
import model.TireType;
import model.VehicleOwner;

import java.time.LocalDate;
import java.util.List;

@Data
public class VehicleDTO {

    private int id;

    private String model;

    private String brand;

    private String plateNumber;

    private Long vin;

    private int mileage;

    private TireType tireType;

    private String insuranceType;

    private DkvNumber dkvNumber;

    private String gpsNumber;

    private VehicleOwner ownersName;

    private LocalDate tufExpirationDate;

    private LocalDate insuranceExpirationDate;

    private int oilChangeIndicator;

    private int fuelInjectorChangeIndicator;

    private int timingBeltChangeIndicator;

    private int adBlueChangeIndicator;

    private List<EmployeeDTO> driversNameDTO; // it was List<Employee>

//    private List images; // TODO LEARN THIS

    private boolean fuelInjectorFilterChangeRequired;

    private boolean antiFrostChangeRequired;

    private boolean airFilterChangeRequired;

    private boolean insideAirFilterChangeRequired;

    private boolean brakeFluidChangeRequired;

    private int project;

    private int employeeId;



}
