package com.example.flight.scheduledJob;

import com.example.flight.model.Flights;
import com.example.flight.service.FlightsService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FlightScheduledJob {

    private final FlightsService flightService;

    public FlightScheduledJob(FlightsService flightService) {
        this.flightService = flightService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void fetchAndSaveFlights() {

        List<Flights> mockFlights = MockApi.fetchFlights();

        flightService.saveFlights(mockFlights);
    }
}