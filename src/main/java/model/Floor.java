package model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class Floor {

    @JoinColumn(name = "accommodation_id")
    private int accommodationId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Room> rooms;
}
