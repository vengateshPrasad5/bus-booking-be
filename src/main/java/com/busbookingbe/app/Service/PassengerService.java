package com.busbookingbe.app.Service;

import com.busbookingbe.app.Dto.PassengerDTO;
import com.busbookingbe.app.Respository.PassengerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

public interface PassengerService {

    List<Objects> getPassengerCustomerId(Long customerId);

}
