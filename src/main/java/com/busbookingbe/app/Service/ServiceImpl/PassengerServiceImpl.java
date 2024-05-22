package com.busbookingbe.app.Service.ServiceImpl;

import com.busbookingbe.app.Respository.PassengerRepository;
import com.busbookingbe.app.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public List<Objects> getPassengerCustomerId(Long customerId) {
        return passengerRepository.findByPassengerCustomerId(customerId);
    }
}
