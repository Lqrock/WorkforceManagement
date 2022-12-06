package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "room") // TODO dto for room
public class Room {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "beds")
    private int beds;

    @JoinColumn(name = "floor_id")
    private int floorId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Furniture> furniture;

}
