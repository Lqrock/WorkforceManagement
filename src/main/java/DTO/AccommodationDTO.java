package DTO;

import lombok.Data;
import model.Floor;
import model.OwnershipType;
import model.Utility;
import java.io.File;
import java.util.List;

@Data
public class AccommodationDTO {

    private int id;

    private String ownersName;

    private String ownersPhoneNumber;

    private String email;

    private OwnershipType ownershipType;

    private Long ownersBankAccount;

    private String province;

    private String city;

    private String address;

    private Long postalCode;

    private int houseNumber;

    private List<Floor> floors;

    private boolean hasInternet;

    private boolean hasParking;

    private List<Utility> utilities;

    private float rent;

    private float deposit;

    private File contractFile;

    private int rentalPeriod;

    private int noticePeriod;
}
