package com.booking.flight.controller;
import com.booking.flight.dao.passengers.PassengerDetailingDto;
import com.booking.flight.dao.passengers.PassengersDto;
import com.booking.flight.model.Passengers;
import com.booking.flight.service.PassengersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

@RestController
@RequestMapping("passenger")
public class PassengersController {

    @Autowired
    private PassengersService service;

    @PostMapping
    public ResponseEntity passengerRegistration(@RequestBody @Valid PassengersDto dto, UriComponentsBuilder uriBuilder) {
        Passengers p = service.savePassengers(dto);
        var uri = uriBuilder.path("/passenger/{id}").buildAndExpand(p.getName()).toUri();
        return ResponseEntity.created(uri).body(new PassengerDetailingDto(p));
    }


    @GetMapping
    public ResponseEntity<List<Passengers>> getAllPassangers(){
        List<Passengers> listpassenger = service.getAll();
        return ResponseEntity.ok(listpassenger);
    }


    @PutMapping("/{id}")
    public ResponseEntity updatePassenger(@PathVariable("id") Long id, @RequestBody PassengersDto dto){

        Passengers p = service.updatePassenger(dto,id);

        return p != null?
                ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePassenger(@PathVariable Long id){
        service.deletePassenger(id);
        return ResponseEntity.ok().build();
    }

}
