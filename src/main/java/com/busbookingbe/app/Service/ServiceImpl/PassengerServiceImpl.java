package com.busbookingbe.app.Service.ServiceImpl;

import com.busbookingbe.app.Dto.PassengerDTO;
import com.busbookingbe.app.Entity.Passenger;
import com.busbookingbe.app.Respository.PassengerRepository;
import com.busbookingbe.app.Service.PassengerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private PassengerRepository passengerRepository;
    private ModelMapper modelMapper;

    @Override
    public List<PassengerDTO> getPassengerCustomerId(Long customerId) {
         List<PassengerDTO> passengerList = passengerRepository.findByPassengerCustomerId(customerId);

         return passengerList.stream()
                 .map(passenger-> modelMapper.map(passenger,PassengerDTO.class))
                 .collect(Collectors.toList());
    }

    @Override
    public List<Passenger> getBookingByCustomerId(Long userId) {
//        modelMapper.getConfiguration().setAmbiguityIgnored(true);
         List<Passenger> passengerList = passengerRepository.findByCustomerId(userId);
//                .stream().map(passenger ->passenger)
//                .collect(Collectors.toList());
         return passengerList;
    }
}
