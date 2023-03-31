package com.booking.flight.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.booking.flight.dao.aircraft.AircraftDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Table(name = "modelo")
@Entity(name = "Modelo")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    private int seats;
    private String model;

    @JsonIgnore
    @OneToMany(mappedBy="aircraft")
    private List<Flight> flights;


    public Aircraft(String model, int seats){
        this.model = model;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public Integer getNumberOfSeats() {
        return seats;
    }

    public void Seats(Integer seats) {
        this.seats = seats;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Aircraft(AircraftDto data){
        this.model = data.getModel();
        this.seats = data.getSeats();
    }
}
