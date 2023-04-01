package com.booking.flight.dao.flight;
import com.booking.flight.model.Flight;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class FlightDetailingDto {

    private Long id;
    private Integer number;

    private String model;
    private String dateflight;

    private int seats;
    public FlightDetailingDto(Flight flight){
        this.number = flight.getNumber();
        this.dateflight = flight.getDateflight();

    }
}
