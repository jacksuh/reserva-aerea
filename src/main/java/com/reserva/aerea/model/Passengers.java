package com.reserva.aerea.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "passageiro")
@Entity(name = "Passageiro")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Passengers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;

    @ManyToOne@JoinColumn(name="flight_id", referencedColumnName="id",nullable=false)
    private Flight flight;

    public Passengers(String name, String cpf){
        this.name = name;
        this.cpf = cpf;
    }

    public String Passengers(String passengers) {
        return this.name + this.cpf;
    }


    public String getPassengers(){
        return this.name + this.cpf;
    }


}

