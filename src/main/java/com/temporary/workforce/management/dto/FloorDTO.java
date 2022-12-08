package com.temporary.workforce.management.dto;

import lombok.Data;
import java.util.List;

@Data
public class FloorDTO {

    private int id;

    private int accommodation_id;

    private int count;

    private List<RoomDTO> rooms;

}
