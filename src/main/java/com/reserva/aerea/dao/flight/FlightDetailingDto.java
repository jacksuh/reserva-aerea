package com.reserva.aerea.dao.flight;

import com.reserva.aerea.model.Aircraft;
import com.reserva.aerea.model.Flight;

public class FlightDetailingDto {

    private Integer number;

    private Aircraft aircraft;

    private String dateflight;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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

    public FlightDetailingDto(Flight flight){
        this.number = flight.getNumber();
        this.aircraft  = flight.getAircraft();
        this.dateflight = flight.getDateflight();
    }
}
