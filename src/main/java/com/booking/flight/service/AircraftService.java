package com.booking.flight.service;
import com.booking.flight.dao.aircraft.AircraftDto;
import com.booking.flight.model.Aircraft;
import com.booking.flight.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AircraftService {
    @Autowired
    private AircraftRepository repository;
    public Page<Aircraft> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }
    public Aircraft saveAircraft(AircraftDto dto){
        Aircraft aircraft = new Aircraft(dto);
        return repository.save(aircraft);
    }

    public Aircraft updateAircraft(AircraftDto dto, Long id) {
        Optional<Aircraft> optional = repository.findById(id);
            Aircraft db = optional.get();
            db.setModel(dto.getModel());
            db.setSeats(dto.getSeats());
            db.setNumber(dto.getNumber());
            db.setDateflight(dto.getDateflight());
            return repository.save(db);
    }

    public void deleteAircraft(Long id){
        Optional<Aircraft> aircraft = repository.findById(id);
        if(aircraft.isPresent()){
            repository.deleteById(id);
        }
    }


}
