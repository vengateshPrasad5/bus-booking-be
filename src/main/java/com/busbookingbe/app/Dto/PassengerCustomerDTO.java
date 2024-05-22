package com.busbookingbe.app.Dto;

import com.busbookingbe.app.Entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerCustomerDTO {
    private Long passengerId;
    private String name;
    private String age;
    private String gender;
    private Seat seat;
}

