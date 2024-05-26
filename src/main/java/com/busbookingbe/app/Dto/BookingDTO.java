package com.busbookingbe.app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Long seatId;
    private List<PassengerDTO> passengerList;
}
