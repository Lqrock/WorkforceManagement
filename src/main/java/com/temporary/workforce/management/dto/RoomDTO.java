package com.temporary.workforce.management.dto;

import lombok.Data;

@Data
public class RoomDTO {

    private int id;

    private int beds;

    private FloorDTO floor;

//    private List<String> furniture;
}
