package com.temporary.workforce.management.dto;

import com.temporary.workforce.management.model.Accommodation;
import lombok.Data;

import java.util.List;

@Data
public class FloorDTO {

    private int id;

    private AccommodationDTO accommodation;

    private List<RoomDTO> rooms;

}
