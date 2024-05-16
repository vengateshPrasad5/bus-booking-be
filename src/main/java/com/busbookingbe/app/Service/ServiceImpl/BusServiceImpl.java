package com.busbookingbe.app.Service.ServiceImpl;

import com.busbookingbe.app.Dto.BusDto;
import com.busbookingbe.app.Entity.Bus;
import com.busbookingbe.app.Respository.BusRepository;
import com.busbookingbe.app.Service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class BusServiceImpl implements BusService {

    private ModelMapper modelMapper;
    @Autowired
    private BusRepository busRepository;

    @Override
    public List<BusDto> getAllBuses() {
        return busRepository.findAll()
                .stream().map(bus -> modelMapper.map(bus, BusDto.class))
                .collect(Collectors.toList());
    }
}
