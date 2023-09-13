package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "floor")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_id")
    private Accommodation accommodation;

    @OneToMany(mappedBy = "floor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Room> rooms;

}


