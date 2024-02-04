package com.example.flight.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Table(name = "Flights")
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airports departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airports arrivalAirport;
    private Date departureDate;
    private Date returnDate;
    private Long price;

    public Flights(){}
    public Flights( Airports deporteAirport, Airports arrivalAirport, Date departureDate, Date returnDate,Long price) {

        this.departureAirport = deporteAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
    }



}
