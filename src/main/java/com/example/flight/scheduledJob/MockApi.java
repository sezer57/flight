package com.example.flight.scheduledJob;

import com.example.flight.model.Airports;
import com.example.flight.model.Flights;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockApi {

    public static List<Flights> fetchFlights() {
        // Replace this with logic to generate mock flight data
        List<Flights> mockFlights = new ArrayList<>();
        Airports s = new Airports("IST");
        Airports d = new Airports("ANK");
        Flights mockFlight1 = new Flights();
        mockFlight1.setDepartureAirport(s);
        mockFlight1.setArrivalAirport(d);
        mockFlight1.setPrice(1000L);
        mockFlight1.setDepartureDate(new Date());
        mockFlight1.setReturnDate(new Date());
        mockFlights.add(mockFlight1);

        Flights mockFlight2 = new Flights();
        mockFlight2.setDepartureAirport(s);
        mockFlight2.setArrivalAirport(d);
        mockFlight2.setPrice(1000L);
        mockFlight2.setDepartureDate(new Date());
        mockFlight2.setReturnDate(new Date());
        mockFlights.add(mockFlight2);

        // Add more mock flights as needed

        return mockFlights;
    }
}