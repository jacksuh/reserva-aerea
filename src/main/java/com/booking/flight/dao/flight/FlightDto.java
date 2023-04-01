package com.booking.flight.dao.flight;
import com.booking.flight.model.Aircraft;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class FlightDto {

    private Integer number;

    private Aircraft aircraft;

    private String dateflight;

    private int seats;

    private String model;




}
