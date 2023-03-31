package com.reserva.aerea.service;
import com.reserva.aerea.dao.aircraft.AircraftDto;
import com.reserva.aerea.model.Aircraft;
import com.reserva.aerea.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository repository;

    public List<Aircraft> getAll(){
        return repository.findAll();
    }

    public Aircraft saveAircraft(AircraftDto model){
        Aircraft aircraft = new Aircraft(model.getModel(),model.getSeats());
        return repository.save(aircraft);
    }

    public Aircraft updateAircraft(AircraftDto model, Long id) {
        Optional<Aircraft> optional = repository.findById(id);
            Aircraft db = optional.get();
            db.setModel(model.getModel());
            return repository.save(db);
    }

    public void deleteAircraft(Long id){
        Optional<Aircraft> aircraft = repository.findById(id);
        if(aircraft.isPresent()){
            repository.deleteById(id);
        }
    }


}
