package com.booking.flight.controller;
import com.booking.flight.dao.passengers.PassengerDetailingDto;
import com.booking.flight.dao.passengers.PassengersDto;
import com.booking.flight.model.Passengers;
import com.booking.flight.service.PassengersService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@Log4j2
@RestController
@RequestMapping("passenger")
public class PassengersController {

    @Autowired
    private PassengersService service;

    @PostMapping
    public ResponseEntity passengerRegistration(@RequestBody @Valid PassengersDto dto, UriComponentsBuilder uriBuilder) {
        Passengers p = service.savePassengers(dto);
        var uri = uriBuilder.path("/passenger/{id}").buildAndExpand(p.getName()).toUri();
        log.info("Entry Name: {}" , dto.getName());
        log.info("Entry CPf: {}", dto.getCpf());
        log.info("Entry Aicraft: {}", dto.getAircraft().getId());
        log.info("Return: {}",p.getId());
        log.info("Return: {}",p.getName());
        log.info("Return: {}",p.getCpf());
        System.out.println(dto.getAircraft().getId());
        return ResponseEntity.created(uri).body(new PassengerDetailingDto(p));
    }


    @GetMapping
    public ResponseEntity<Page<Passengers>> getAllPassangers(@PageableDefault(sort = "id", page = 0, size = 10) Pageable page){
        Page<Passengers> listpassenger = service.getAll(page);
        return ResponseEntity.ok(listpassenger);
    }


    @PutMapping("/{id}")
    public ResponseEntity updatePassenger(@PathVariable("id") Long id, @RequestBody PassengersDto dto){

        Passengers p = service.updatePassenger(dto,id);
        log.info("teste {}", dto.getName());
        log.info("Update Id: {}", id);
        log.info("Update: {}", p.getName());
        log.info("Update: {}", p.getCpf());
      //  log.info("Update: {}", p.getFlight());
        return p != null?
                ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePassenger(@PathVariable Long id){
        service.deletePassenger(id);
        log.info("Delete: {}", id);
        return ResponseEntity.ok().build();
    }

}
