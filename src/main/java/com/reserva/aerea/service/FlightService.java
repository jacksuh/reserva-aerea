package com.reserva.aerea.service;

import com.reserva.aerea.dao.flight.FlightDto;
import com.reserva.aerea.model.Aircraft;
import com.reserva.aerea.model.Flight;
import com.reserva.aerea.repository.AircraftRepository;
import com.reserva.aerea.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FlightService {

    @Autowired
    FlightRepository repository;

    @Autowired
    private AircraftRepository aircraftRepository;

    public Flight saveFlight(FlightDto data){
        Long idAircraft = data.getAircraft().getId();
        Aircraft aircraft =
                aircraftRepository.findById(idAircraft)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aircraft"));

        Flight flight = new Flight();
        flight.setNumber(data.getNumber());
        flight.setDateflight(data.getDateflight());
        flight.setAircraft(aircraft);

        return repository.save(flight);
    }
}
