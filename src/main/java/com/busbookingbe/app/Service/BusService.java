package com.busbookingbe.app.Service;

import com.busbookingbe.app.Dto.BusDto;
import com.busbookingbe.app.Entity.Bus;

import java.util.List;

public interface BusService {
    List<BusDto>getAllBuses();
}
