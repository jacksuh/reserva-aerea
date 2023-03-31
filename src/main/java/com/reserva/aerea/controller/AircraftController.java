package com.reserva.aerea.controller;

import com.reserva.aerea.dao.aircraft.AircraftDto;
import com.reserva.aerea.model.Aircraft;
import com.reserva.aerea.service.AircraftService;
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
        return ResponseEntity.created(uri).body(new Aircraft(ar.getModel(), ar.getNumberOfSeats()));
    }

    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircraft(){
        List<Aircraft> listaircraft = service.getAll();
        return ResponseEntity.ok(listaircraft);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateAircraft(@PathVariable("id") Long id, @RequestBody AircraftDto data){

        Aircraft f = service.updateAircraft(data,id);

        return f != null?
                ResponseEntity.ok(f) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletAircraft(@PathVariable Long id){
        service.deleteAircraft(id);
        return ResponseEntity.ok().build();
    }

}
