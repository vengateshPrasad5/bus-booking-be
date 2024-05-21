package com.busbookingbe.app.Dto;

import com.busbookingbe.app.Entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDTO {
    private Long busId;
    private String name;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private long price;
    private String busType;
    private int numberOfSeats;
    private List<Seat> seats;
}



