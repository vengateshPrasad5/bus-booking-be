package com.busbookingbe.app.Dto;

import com.busbookingbe.app.Entity.Booking;
import com.busbookingbe.app.Entity.Seat;
import com.busbookingbe.app.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
    private Long passengerId;
    private String name;
    private String age;
    private String gender;
    private Seat seat;
    private User user;
    private Booking booking;
}
