package com.booking.flight.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class Flight {

    private Integer number;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateflight;

}
