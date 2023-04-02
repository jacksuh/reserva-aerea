package com.booking.flight.model;
import com.booking.flight.dao.passengers.PassengersDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name = "passageiro")
@Entity(name = "Passageiro")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Getter
@Setter
public class Passengers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;
    @JsonIgnore
    @ManyToOne@JoinColumn(name="aircraft_id", referencedColumnName="id",nullable=false)
    private Aircraft aircraft;

    public Passengers(PassengersDto dto){
        this.setName(dto.getName());
        this.setCpf(dto.getCpf());
        this.setAircraft(dto.getAircraft());
    }
}

