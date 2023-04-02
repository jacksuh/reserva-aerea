package com.booking.flight.dao.passengers;
import com.booking.flight.model.Aircraft;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PassengersDto {

    private String name;

    private String cpf;

    private Aircraft aircraft;
}
