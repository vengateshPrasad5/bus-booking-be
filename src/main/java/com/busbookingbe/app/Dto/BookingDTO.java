package com.busbookingbe.app.Dto;

import com.busbookingbe.app.Entity.Bus;
import com.busbookingbe.app.Entity.Passenger;
import com.busbookingbe.app.Entity.Seat;
import com.busbookingbe.app.Entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long bookingId;
    private String reservationDate;
    private String status;
    private Long userId;
    private Long busId;
    private List<Seat> seats;
    private List<Passenger> passengerList;
}
