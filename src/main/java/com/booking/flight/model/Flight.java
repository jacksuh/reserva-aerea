package com.booking.flight.model;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Table(name = "voo")
@Entity(name = "Voo")
@EqualsAndHashCode(of = "idFlight")
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateflight;

}
