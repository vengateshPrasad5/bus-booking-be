package com.busbookingbe.app.Dto;

import com.busbookingbe.app.Entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDTO {
    private Long busId;
    private String name;
    private String source;
    private String destination;
    private Date departureTime;
    private LocalDateTime arrivalTime;
    private long price;
    private String busType;
    private int numberOfSeats;
    private List<Seat> seats;
}



