package model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class Room {

    @JoinColumn(name = "floor_id")
    private int floorId;


    @OneToMany(fetch = FetchType.LAZY)
    private List<Furniture> furnitures; // TODO nid

    private int beds;
}
