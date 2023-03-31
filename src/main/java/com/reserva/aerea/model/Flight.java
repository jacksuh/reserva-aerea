package com.reserva.aerea.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reserva.aerea.dao.flight.FlightDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;


@Table(name = "voo")
@Entity(name = "Voo")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="aircraft_id", referencedColumnName="id",nullable=false)
    private Aircraft aircraft;

    @OneToMany(mappedBy = "flight")
    List<Passengers> passengers;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateflight;


    public Flight(int number, Aircraft aircraft, String dateflight){
        this.number = number;
        this.aircraft = aircraft;
        this.dateflight = dateflight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public Flight(FlightDto data){
        this.number = data.getNumber();
        this.aircraft = data.getAircraft();
        this.dateflight = data.getDateflight();
    }
}
