package com.example.flight.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class FlightsDto {
    private String deporteAirport;
    private String arrivalAirport;
    private Long price;
    private Date departureDate;
    private Date returnDate;
}
