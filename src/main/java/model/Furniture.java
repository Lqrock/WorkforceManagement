package model;

import javax.persistence.JoinColumn;

public class Furniture {
    private int id;

    private String name;

    @JoinColumn(name = "accommodation_id")
    private int accommodationId;



}


