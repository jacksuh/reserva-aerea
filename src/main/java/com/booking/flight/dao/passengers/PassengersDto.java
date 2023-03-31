package com.booking.flight.dao.passengers;
import com.booking.flight.model.Flight;
public class PassengersDto {

    private String name;

    private String cpf;

    private Flight flight;

    public String PassengersData(String nome, String cpf, Flight flight) {
        this.name = nome;
        this.cpf = cpf;
        this.flight = flight;
        return nome + cpf + flight;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
