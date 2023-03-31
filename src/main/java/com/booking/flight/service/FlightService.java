package com.booking.flight.service;
import com.booking.flight.dao.flight.FlightDto;
import com.booking.flight.model.Aircraft;
import com.booking.flight.repository.AircraftRepository;
import com.booking.flight.model.Flight;
import com.booking.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
@Service
public class FlightService {

    @Autowired
    FlightRepository repository;

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Flight> getAll(){
        return repository.findAll();
    }


    public Flight saveFlight(FlightDto data){
        Long idAircraft = data.getAircraft().getId();
        Aircraft aircraft =
                aircraftRepository.findById(idAircraft)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flight"));

        Flight flight = new Flight();
        flight.setNumber(data.getNumber());
        flight.setDateflight(data.getDateflight());
        flight.setAircraft(aircraft);

        return repository.save(flight);
    }

    public Flight updateFligtht(FlightDto dto, Long id) {
        Optional<Flight> optional = repository.findById(id);
        Flight db = optional.get();
        db.setNumber(dto.getNumber());
        dto.setAircraft(dto.getAircraft());
        dto.setDateflight(dto.getDateflight());

        return repository.save(db);
    }

    public void deleteFlitgh(Long id) {
        Optional<Flight> fligtht = repository.findById(id);
        if (fligtht.isPresent()) {
            repository.deleteById(id);
        }

    }
}
