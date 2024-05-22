package com.busbookingbe.app.Service.ServiceImpl;

import com.busbookingbe.app.Dto.BusDTO;
import com.busbookingbe.app.Entity.Bus;
import com.busbookingbe.app.Respository.BusRepository;
import com.busbookingbe.app.Service.BusService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusServiceImpl implements BusService {

    private ModelMapper modelMapper;
    private BusRepository busRepository;

    @Override
    public List<BusDTO> getAllBuses() {
        return busRepository.findAll()
                .stream().map(bus -> modelMapper.map(bus, BusDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BusDTO getBusById(Long id) {
        Bus bus =  busRepository.findById(id).get();
        return modelMapper.map(bus, BusDTO.class);
    }

    @Override
    public List<BusDTO> getBySourceDestinationAndDepartureDate(String source, String destination, String departureTime) {
        return busRepository.findBySourceDestinationAndDepartureDate(source,destination,departureTime)
                .stream().map(bus -> modelMapper.map(bus, BusDTO.class))
                .collect(Collectors.toList());
    }

}