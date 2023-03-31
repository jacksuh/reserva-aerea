package com.booking.flight.dao.flight;
import com.booking.flight.model.Aircraft;

public class FlightDto {

    private Integer number;

    private Aircraft aircraft;

    private String dateflight;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public String getDateflight() {
        return dateflight;
    }

    public void setDateflight(String dateflight) {
        this.dateflight = dateflight;
    }
}
