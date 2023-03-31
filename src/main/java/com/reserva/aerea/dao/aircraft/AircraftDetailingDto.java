package com.reserva.aerea.dao.aircraft;

import com.reserva.aerea.model.Aircraft;

public class AircraftDetailingDto {

    private Long id;

    public AircraftDetailingDto(Aircraft aircraft){
        this.id = aircraft.getId();
    }
}
