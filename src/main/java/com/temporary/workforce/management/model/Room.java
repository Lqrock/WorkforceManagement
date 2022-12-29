package com.temporary.workforce.management.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "beds")
    private int beds;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "floor_id")
    private Floor floor;

//    @OneToMany(fetch = FetchType.LAZY)
//    private List<Furniture> furniture;

}
