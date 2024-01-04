package com.hotelreservation.apigateway.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {

    private Long id;
    private int floor;
    private int roomsize;
    private int price;
    private String isAvailable;
}