package com.busbookingbe.app.Controller;

import com.busbookingbe.app.Dto.BusDTO;
import com.busbookingbe.app.Service.ServiceImpl.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/bus")
public class BusController {

    @Autowired
    BusServiceImpl busServiceImpl;

    @GetMapping("/getSourceList")
    public ResponseEntity<List<String>> sourceList(){
        List<String> sources = busServiceImpl.getDistinctSource();
        return new ResponseEntity<>(sources , HttpStatus.OK);
    }

    @GetMapping("/getDepartureList")
    public ResponseEntity<List<String>> destinationList(){
        List<String> destinations = busServiceImpl.getDistinctDestination();
        return new ResponseEntity<>(destinations , HttpStatus.OK);
    }

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
                                                 @RequestParam String departureDate) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate reservationDate = LocalDate.parse(departureDate, formatter);
        List<BusDTO> busList = busServiceImpl.getBySourceDestinationAndDepartureDate(source, destination, reservationDate);
        return new ResponseEntity<>(busList, HttpStatus.OK);
    }
}
