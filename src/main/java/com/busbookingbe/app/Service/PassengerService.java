package com.busbookingbe.app.Service;

import com.busbookingbe.app.Dto.PassengerDTO;
import com.busbookingbe.app.Entity.Passenger;

import java.util.List;

public interface PassengerService {

    List<PassengerDTO> getPassengerCustomerId(Long customerId);

    List<Passenger> getBookingByCustomerId(Long userId);


}
