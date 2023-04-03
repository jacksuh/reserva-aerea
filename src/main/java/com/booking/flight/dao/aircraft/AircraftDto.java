package com.booking.flight.dao.aircraft;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class AircraftDto {

    private Long id;

    private String model;

    private int seats;

    private int number;

    private String dateflight;


}
