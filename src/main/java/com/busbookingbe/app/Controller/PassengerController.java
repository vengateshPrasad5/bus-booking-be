package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.PassengerDTO;
import com.busbookingbe.app.Entity.Passenger;
import com.busbookingbe.app.Exception.ResourceNotFoundException;
import com.busbookingbe.app.Service.ServiceImpl.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerController {
    @Autowired
    PassengerServiceImpl passengerServiceImpl;

    @GetMapping("/getPassengerList")
    public ResponseEntity<List<PassengerDTO>> passengerList(@RequestParam Long customerId){
        try {
            List<PassengerDTO>passengerList = passengerServiceImpl.getPassengerCustomerId(customerId);
            return new ResponseEntity<>(passengerList, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/getBookingListByCustomer")
    public ResponseEntity<List<Passenger>>bookingListByCustomer(@RequestParam Long userId) {
        try {
            List<Passenger> bookingList = passengerServiceImpl.getBookingByCustomerId(userId);
            return new ResponseEntity<>(bookingList, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }
}
