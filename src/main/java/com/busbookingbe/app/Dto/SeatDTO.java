package com.busbookingbe.app.Dto;


import com.busbookingbe.app.Entity.Bus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private Long seatId;
    private String seatNo;
    private int height;
    private int busRow;
    private Bus bus;
}
