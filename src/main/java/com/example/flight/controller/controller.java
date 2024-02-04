package com.example.flight.controller;

import com.example.flight.dto.AirportDto;
import com.example.flight.dto.FlightsDto;
import com.example.flight.model.AuthRequest;
import com.example.flight.model.Flights;
import com.example.flight.model.UserInfo;
import com.example.flight.service.AirportsService;
import com.example.flight.service.FlightsService;
import com.example.flight.service.Jwt.JwtService;
import com.example.flight.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class controller {

    private final UserService service;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private  final FlightsService flightsService;
    private final AirportsService airportsService;
    public controller(UserService service, JwtService jwtService, AuthenticationManager authenticationManager, FlightsService flightsService, AirportsService airportsService) {
        this.service = service;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.flightsService = flightsService;
        this.airportsService = airportsService;
    }


    //Authentication Endpoints
    @PostMapping("/addNewUser")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }


    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

    @PostMapping("/addAirport")
    @PreAuthorize("hasAuthority('Admin')")
    public String addAirport(@RequestBody AirportDto airportDto) {

        return airportsService.save(airportDto);
    }

    @PostMapping("/addFlights")
    @PreAuthorize("hasAuthority('Admin')")
    public String addFlights(@RequestBody FlightsDto flightsDto) {

        return flightsService.save(flightsDto);
    }


    @GetMapping("/flights")
    @PreAuthorize("hasAuthority('User')")
    public List<Flights> searchFlights( @RequestParam String departureAirport,
                                        @RequestParam String arrivalAirport,
                                        @RequestParam String departureDate,
                                        @RequestParam(required = false) String returnDate) {
        if (returnDate == null) {
            return flightsService.searchFlights(departureAirport, arrivalAirport, parseDateString(departureDate), null);
        } else {
            return flightsService.searchFlights(departureAirport, arrivalAirport, parseDateString(departureDate), parseDateString(returnDate));
        }
    }


    private Date parseDateString(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
