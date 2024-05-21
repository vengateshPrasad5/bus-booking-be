package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.BusDTO;
import com.busbookingbe.app.Entity.Bus;
import com.busbookingbe.app.Service.ServiceImpl.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BusController {

    @Autowired
    BusServiceImpl busServiceImpl;

    @GetMapping("/getBusList")
    public ResponseEntity<List<BusDTO>> getAllBus(){
      List<BusDTO> busList = busServiceImpl.getAllBuses();
      return new ResponseEntity<>(busList , HttpStatus.OK);
    }

    @GetMapping("/getBusById/{id}")
    public ResponseEntity<BusDTO> getByBusId(@PathVariable("id")Long id){
        BusDTO bus = busServiceImpl.getBusById(id);
        return new ResponseEntity<>(bus,HttpStatus.OK);
    }

    @GetMapping("/searchBus")
    public ResponseEntity<List<BusDTO>> getBuses(@RequestParam String source,
                                                                       @RequestParam String destination,
                                                                       @RequestParam String departureDate)
    {
        List<BusDTO> busList = busServiceImpl.getBySourceDestinationAndDepartureDate(source, destination, departureDate);
        return new ResponseEntity<>(busList, HttpStatus.OK);
    }
}
