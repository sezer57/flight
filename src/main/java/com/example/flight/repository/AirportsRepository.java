package com.example.flight.repository;

import com.example.flight.model.Airports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportsRepository extends JpaRepository<Airports, Long> {
    Airports findAirportsByLocation(String name);

}
