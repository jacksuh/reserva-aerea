package com.booking.flight.model;
import com.booking.flight.dao.aircraft.AircraftDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Table(name = "aviao")
@Entity(name = "Aviao")
@EqualsAndHashCode(of = "idAviao")
@NoArgsConstructor
@Getter
@Setter
public class  Aircraft extends Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int seats;

    private String model;

    @OneToMany(mappedBy = "aircraft")
    List<Passengers> passengers;

    public Aircraft(AircraftDto dto) {
        this.setId(dto.getId());
        this.setModel(dto.getModel());
        this.setSeats(dto.getSeats());
        this.setNumber(dto.getNumber());
        this.setDateflight(dto.getDateflight());
    }

}
