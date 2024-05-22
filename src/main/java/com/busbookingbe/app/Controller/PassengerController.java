package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.PassengerDTO;
import com.busbookingbe.app.Entity.Passenger;
import com.busbookingbe.app.Service.ServiceImpl.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerController {
    @Autowired
    PassengerServiceImpl passengerServiceImpl;

    @GetMapping("/getPassengerList")
    public ResponseEntity<List<PassengerDTO>> passengerList(@RequestParam Long customerId){
        List<PassengerDTO>passengerList = passengerServiceImpl.getPassengerCustomerId(customerId);
        return new ResponseEntity<>(passengerList, HttpStatus.OK);
    }

    @GetMapping("/getBookingListByCustomer")
    public ResponseEntity<List<Passenger>>bookingListByCustomer(@RequestParam Long userId) {
        List<Passenger> bookingList = passengerServiceImpl.getBookingByCustomerId(userId);
        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }
}
