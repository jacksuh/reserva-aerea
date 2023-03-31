/**package com.reserva.aerea.controller;
import com.reserva.aerea.dao.AirplaneData;
import com.reserva.aerea.model.Aircraft;
import com.reserva.aerea.model.Airplane;
import com.reserva.aerea.model.Passengers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("airplane")
public class AirplaneController {

    @PostMapping
    public ResponseEntity airplaneRegistration(@RequestBody AirplaneData place) {
        Airplane a = new Airplane(place.getModel(), place.getRanks(),
                place.getSeats(), place.getPassengers(), place.getRankspassenger(),
                place.getSeatspassenger());

        a.setPassengers(place.getRankspassenger(), place.getSeatspassenger(),
                place.getPassengers());
        return ResponseEntity.ok(a.getPassengers(place.getRankspassenger(), place.getSeatspassenger()).getPassengers());
    }

    @GetMapping
    public ResponseEntity getAircraft(){
       // Aircraft newss = new Aircraft("teste");

        return ResponseEntity.ok(newss);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAircraft(@PathVariable Long id){
        return ResponseEntity.ok(id);
    }
}
**/