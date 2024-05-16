package com.busbookingbe.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private Long busId;
    private String name;
    private String source;
    private String destination;
    private Date departureTime;
    private Date arrivalTime;
    private long price;
    private String busType;
    private int numberOfSeats;
}



