package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "furniture")
public class Furniture {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @JoinColumn(name = "accommodation_id")
    private int accommodationId;

    @JoinColumn(name = "room_id")
    private int roomId;
}


