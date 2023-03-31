package com.booking.flight.dao.aircraft;
import com.booking.flight.model.Aircraft;

public class AircraftDetailingDto {

    private Long id;

    private String model;

    private int seats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public AircraftDetailingDto(Aircraft aircraft){
        this.id = aircraft.getId();
        this.model = aircraft.getModel();
        this.seats = aircraft.getNumberOfSeats();
    }
}
