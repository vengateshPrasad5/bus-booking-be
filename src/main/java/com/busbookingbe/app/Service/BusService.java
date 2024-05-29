package com.busbookingbe.app.Service;

import com.busbookingbe.app.Dto.BusDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BusService {
    List<BusDTO>getAllBuses();
    BusDTO getBusById(Long id);
    List<BusDTO>getBySourceDestinationAndDepartureDate(String source, String destination, Date departureTime);
    List<String>getDistinctSource();
    List<String>getDistinctDestination();


}
