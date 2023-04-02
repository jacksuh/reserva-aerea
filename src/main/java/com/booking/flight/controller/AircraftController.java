package com.booking.flight.controller;
import com.booking.flight.dao.aircraft.AircraftDetailingDto;
import com.booking.flight.dao.aircraft.AircraftDto;
import com.booking.flight.model.Aircraft;
import com.booking.flight.service.AircraftService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
@Log4j2
@RestController
@RequestMapping("aircraft")
public class AircraftController {

    @Autowired
    private AircraftService service;

    @PostMapping
    @CacheEvict(value = "aircraft", allEntries = true)
    public ResponseEntity aircraftRegistration(@RequestBody @Valid AircraftDto dto, UriComponentsBuilder uriBuilder) {
        Aircraft ar = service.saveAircraft(dto);
            var uri = uriBuilder.path("/aircraft/{id}").buildAndExpand(ar.getModel()).toUri();
        log.info("Entry Model Entrada: {}" , dto.getModel());
        log.info("Entry NumberOfSeats: {}", dto.getSeats());
        log.info("Entry Number: {}", dto.getNumber());
        log.info("Entry Date: {}", dto.getDateflight());
        log.info("Return: {}",ar.getModel());
        log.info("Return: {}",ar.getSeats());
        log.info("Return: {}",ar.getDateflight());
        log.info("Return: {}",ar.getNumber());
        log.info("Return: {}",ar.getId());
        return ResponseEntity.created(uri).body(new AircraftDetailingDto(ar));

    }

    @GetMapping
    @Cacheable(value = "aircraft")
    public ResponseEntity<Page<Aircraft>> getAllAircraft(@PageableDefault(sort = "model", page = 0, size = 10) Pageable page){
        Page<Aircraft> listaircraft = service.getAll(page);
        return ResponseEntity.ok(listaircraft);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "aircraft", allEntries = true)
    public ResponseEntity updateAircraft(@PathVariable("id") Long id, @RequestBody AircraftDto dto){

        Aircraft a = service.updateAircraft(dto,id);
        log.info("Update Id: {}", id);
        log.info("Update: {}", a.getModel());
        log.info("Update: {}", a.getSeats());
        log.info("Update: {}", a.getDateflight());
        log.info("Update: {}", a.getNumber());
      //  log.info("Update: {}", a.getPassengers());
        return a != null?
                ResponseEntity.ok(a) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "aircraft", allEntries = true)
    public ResponseEntity deleteAircraft(@PathVariable Long id){
        service.deleteAircraft(id);
        log.info("Delete: {}", id);
        return ResponseEntity.ok().build();
    }

}
