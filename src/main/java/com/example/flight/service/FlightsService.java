package com.example.flight.service;

import com.example.flight.dto.FlightsDto;
import com.example.flight.model.Flights;
import com.example.flight.repository.FlightsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class FlightsService {
    private final FlightsRepository flightsRepository;
    private final AirportsService airportsService;

    public FlightsService(FlightsRepository flightsRepository, AirportsService airportsService) {
        this.flightsRepository = flightsRepository;
        this.airportsService = airportsService;
    }

    public String save(FlightsDto f){
        if(airportsService.findAirportsWithName(f.getArrivalAirport())==null){
            return "wrong ArrivalAirport";
        }
        else if(airportsService.findAirportsWithName(f.getDeporteAirport())==null){
            return "wrong DeporteAirport";
        }
        Flights s = new Flights(airportsService.findAirportsWithName(f.getDeporteAirport()),
                airportsService.findAirportsWithName(f.getArrivalAirport()),
                f.getDepartureDate(),
                f.getReturnDate(),
                f.getPrice());
        flightsRepository.save(s);
        return "succes";
    }
    public void saveFlights(List<Flights> flights) {
        flightsRepository.saveAll(flights);
    }


    public List<Flights> searchFlights(String departureAirport, String arrivalAirport, Date departureDate, Date returnDate) {

        if (returnDate == null) {
            return flightsRepository.findByDepartureAirportAndAndArrivalAirportAndDepartureDate(
                            airportsService.findAirportsWithName(departureAirport),airportsService.findAirportsWithName(arrivalAirport), departureDate);
        } else {
            return flightsRepository.findByDepartureAirportAndAndArrivalAirportAndDepartureDateAndReturnDate(
                    airportsService.findAirportsWithName(departureAirport),airportsService.findAirportsWithName(arrivalAirport), departureDate, returnDate);
        }
    }
}
