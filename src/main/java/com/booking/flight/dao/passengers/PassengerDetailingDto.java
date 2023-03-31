package com.booking.flight.dao.passengers;
import com.booking.flight.model.Flight;
import com.booking.flight.model.Passengers;
public class PassengerDetailingDto {


    private Long id;

    private String name;

    private String cpf;

    private Flight flight;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public PassengerDetailingDto(Passengers passengers){
        this.id = passengers.getId();
        this.name = passengers.getName();
        this.cpf = passengers.getCpf();
        this.flight = passengers.getFlight();
    }
}
