package com.learning.airport.controller;

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
    private AirportRepository airportRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @PostMapping("addAirport")
    public Airport createAirport(@RequestBody Airport airport) {
        return airportRepository.saveAndFlush(airport);
    }

    @GetMapping("getAirport/{id}")
    public Airport getAirport(@PathVariable Long id) {
        return airportRepository.findById(id).get();
    }

    @PostMapping("addPassenger/{id}")
    public Passenger createAirport(@PathVariable Long id, @RequestBody Passenger passenger) {
        Airport airport = airportRepository.findById(id).get();
        passenger.setAirport(airport);
        Passenger passenger1= passengerRepository.saveAndFlush(passenger);
        return passenger1;
    }
}
