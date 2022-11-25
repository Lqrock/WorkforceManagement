package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Data
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


