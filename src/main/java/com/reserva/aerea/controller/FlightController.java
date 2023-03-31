package com.reserva.aerea.controller;


import com.reserva.aerea.dao.flight.FlightDto;
import com.reserva.aerea.dao.flight.FlightDetailingDto;
import com.reserva.aerea.model.Flight;
import com.reserva.aerea.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("flight")
public class FlightController {


    @Autowired
    private FlightService service;

    @PostMapping
    public ResponseEntity flightRegistration(@RequestBody @Valid FlightDto data, UriComponentsBuilder uriBuilder) {
        Flight f = service.saveFlight(data);
        var uri = uriBuilder.path("/flight/{id}").buildAndExpand(f.getNumber()).toUri();
        return ResponseEntity.created(uri).body(new FlightDetailingDto(f));
    }
}
