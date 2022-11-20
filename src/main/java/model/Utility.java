package model;

import javax.persistence.JoinColumn;

public class Utility {

    private int id;
    private String name;

    @JoinColumn(name = "accommodation_id")
    private int accommodationId;
}
