package com.example.flight.service;

import com.example.flight.dto.AirportDto;
import com.example.flight.model.Airports;
import com.example.flight.repository.AirportsRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportsService {

    private final AirportsRepository airportsRepository;

    public AirportsService(AirportsRepository airportsRepository) {
        this.airportsRepository = airportsRepository;
    }

    public Airports findAirportsWithName(String name){
        return airportsRepository.findAirportsByLocation(name);
    }

    public String save(AirportDto a){
        Airports aa = new Airports(a.getLocation());
        airportsRepository.save(aa);
        return "success airport : "+aa;
    }
}
