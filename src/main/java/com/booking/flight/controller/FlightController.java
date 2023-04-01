package com.booking.flight.controller;
import com.booking.flight.model.Flight;
import com.booking.flight.service.FlightService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Log4j2
@RestController
@RequestMapping("flight")
public class FlightController {
    @Autowired
    private FlightService service;
    @GetMapping
    public ResponseEntity<Page<Flight>> getAllFlight(@PageableDefault(sort = "id", page = 0, size = 10) Pageable page){
        Page<Flight> listflight = service.getAll(page);
        return ResponseEntity.ok(listflight);
    }
}
