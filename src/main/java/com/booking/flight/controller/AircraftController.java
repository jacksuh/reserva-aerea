package com.booking.flight.controller;
import com.booking.flight.dao.aircraft.AircraftDetailingDto;
import com.booking.flight.dao.aircraft.AircraftDto;
import com.booking.flight.model.Aircraft;
import com.booking.flight.service.AircraftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("aircraft")
public class AircraftController {

    @Autowired
    private AircraftService service;

    @PostMapping
    public ResponseEntity aircraftRegistration(@RequestBody @Valid AircraftDto model, UriComponentsBuilder uriBuilder) {
        Aircraft ar = service.saveAircraft(model);
            var uri = uriBuilder.path("/aircraft/{id}").buildAndExpand(ar.getModel()).toUri();
        return ResponseEntity.created(uri).body(new AircraftDetailingDto(ar));
    }

    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircraft(){
        List<Aircraft> listaircraft = service.getAll();
        return ResponseEntity.ok(listaircraft);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAircraft(@PathVariable("id") Long id, @RequestBody AircraftDto dto){

        Aircraft a = service.updateAircraft(dto,id);

        return a != null?
                ResponseEntity.ok(a) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAircraft(@PathVariable Long id){
        service.deleteAircraft(id);
        return ResponseEntity.ok().build();
    }

}
