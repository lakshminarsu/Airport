package com.learning.airport.controller;

import com.learning.airport.AirportService;
import com.learning.airport.Repository.AirportRepository;
import com.learning.airport.Repository.PassengerRepository;
import com.learning.airport.model.Airport;
import com.learning.airport.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("airports")
public class AirportController {

    @Autowired
    AirportService airportService;

    @PostMapping("addAirport")
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @GetMapping("getAirport/{id}")
    public Airport getAirport(@PathVariable Long id) {
        return airportService.getAirport(id);
    }

    @PostMapping("addPassenger/{id}")
    public Passenger addPassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        return airportService.createPassenger(id, passenger);
    }
}
