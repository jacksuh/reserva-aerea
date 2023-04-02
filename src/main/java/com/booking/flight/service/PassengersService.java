package com.booking.flight.service;
import com.booking.flight.dao.passengers.PassengersDto;
import com.booking.flight.model.Aircraft;
import com.booking.flight.repository.AircraftRepository;
import com.booking.flight.repository.PassengersRepository;
import com.booking.flight.model.Flight;
import com.booking.flight.model.Passengers;
//import com.booking.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@Service
public class PassengersService {
    @Autowired
    private PassengersRepository repository;
    @Autowired
    private AircraftRepository aircraftRepository;

    public Page<Passengers> getAll(Pageable page){
        return repository.findAll(page);
    }
    public Passengers savePassengers(PassengersDto dto){
        Long idAircraft = dto.getAircraft().getId();
 

          Aircraft aircraft =
                aircraftRepository.findById(idAircraft)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Aicraft not found"));

        Passengers passengers1 = new Passengers();
        passengers1.setName(dto.getName());
        passengers1.setCpf(dto.getCpf());
        passengers1.setAircraft(aircraft);

        return repository.save(passengers1);
    }
    public Passengers updatePassenger(PassengersDto dto, Long id) {
        Optional<Passengers> optional = repository.findById(id);
        Passengers db = optional.get();
        db.setName(dto.getName());
        db.setCpf(dto.getCpf());
        db.setAircraft(dto.getAircraft());

        return repository.save(db);
    }
    public void deletePassenger(Long id) {
        Optional<Passengers> passengers = repository.findById(id);
        if (passengers.isPresent()) {
            repository.deleteById(id);
        }

    }

}
