package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "floor")
public class Floor {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "count")
    private int count;

    @JoinColumn(name = "accommodation_id")
    private int accommodation_id;

    @OneToMany(mappedBy = "floor_id", fetch = FetchType.LAZY)
    private List<Room> rooms;
}
