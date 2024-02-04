package com.example.flight.repository;

import com.example.flight.model.Airports;
import com.example.flight.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FlightsRepository extends JpaRepository<Flights, Long> {
    Flights findByDepartureDate(Date departureDate);
    List<Flights> findByDepartureAirportAndAndArrivalAirportAndDepartureDate(Airports departureAirport, Airports arrivalAirport, Date departureDate);

    List<Flights> findByDepartureAirportAndAndArrivalAirportAndDepartureDateAndReturnDate(
            Airports departureAirport, Airports arrivalAirport, Date departureDate, Date returnDate);
}
