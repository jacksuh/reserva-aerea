package com.booking.flight.controller;
import com.booking.flight.dao.flight.FlightDto;
import com.booking.flight.dao.flight.FlightDetailingDto;
import com.booking.flight.model.Flight;
import com.booking.flight.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping
    public ResponseEntity flightRegistration(@RequestBody @Valid FlightDto dto, UriComponentsBuilder uriBuilder) {
        Flight f = service.saveFlight(dto);
        var uri = uriBuilder.path("/flight/{id}").buildAndExpand(f.getNumber()).toUri();
        return ResponseEntity.created(uri).body(new FlightDetailingDto(f));
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlight(){
        List<Flight> listflight = service.getAll();
        return ResponseEntity.ok(listflight);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFlight(@PathVariable("id") Long id, @RequestBody FlightDto dto){

        Flight f = service.updateFligtht(dto,id);

        return f != null?
                ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFlight(@PathVariable Long id){
        service.deleteFlitgh(id);
        return ResponseEntity.ok().build();
    }
}
