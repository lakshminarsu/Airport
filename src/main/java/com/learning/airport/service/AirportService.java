package com.learning.airport.service;

import com.learning.airport.Repository.AirportRepository;
import com.learning.airport.Repository.PassengerRepository;
import com.learning.airport.model.Airport;
import com.learning.airport.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    public Airport createAirport(Airport airport) {
        return airportRepository.saveAndFlush(airport);
    }

    public Airport getAirport(Long id) {
        return airportRepository.findById(id).get();
    }

    public Passenger createPassenger(Long airportId, Passenger passenger) {
        Airport airport = airportRepository.findById(airportId).get();
        passenger.setAirport(airport);
        return passengerRepository.saveAndFlush(passenger);
    }
}
