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

    @JoinColumn(name = "accommodation_id")
    private int accommodationId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Room> rooms;
}
