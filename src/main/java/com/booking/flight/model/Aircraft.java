package com.booking.flight.model;
import com.booking.flight.dao.aircraft.AircraftDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class  Aircraft extends Flight {

    private int seats;

    private String model;

    @OneToMany(mappedBy = "flight")
    List<Passengers> passengers;
    public Aircraft(AircraftDto dto){
        this.setId(dto.getId());
        this.setModel(dto.getModel());
        this.setSeats(dto.getSeats());
        this.setNumber(dto.getNumber());
        this.setDateflight(dto.getDateflight());
    }

}
