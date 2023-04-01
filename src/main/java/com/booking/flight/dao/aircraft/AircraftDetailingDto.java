package com.booking.flight.dao.aircraft;
import com.booking.flight.model.Aircraft;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class AircraftDetailingDto {

    private Long id;
    private String model;
    private int seats;
    private String dateflight;
    private int number;
    public AircraftDetailingDto(Aircraft aircraft){
        this.id = aircraft.getId();
        this.model = aircraft.getModel();
        this.seats = aircraft.getSeats();
        this.dateflight = aircraft.getDateflight();
        this.number = aircraft.getNumber();
    }
}
