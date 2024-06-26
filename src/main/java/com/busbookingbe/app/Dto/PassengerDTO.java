package com.busbookingbe.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
    private Long passengerId;
    private String name;
    private int age;
    private String gender;
    private Long seatId;
    private Long userId;
    private Long bookingId;
}
