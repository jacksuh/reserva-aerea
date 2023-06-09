package com.booking.flight.dao.passengers;
import com.booking.flight.model.Aircraft;
import com.booking.flight.model.Passengers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PassengerDetailingDto {
    private Long id;
    private String name;
    private String cpf;
    private Aircraft aircraft;

    public PassengerDetailingDto(Passengers passengers){
        this.id = passengers.getId();
        this.name = passengers.getName();
        this.cpf = passengers.getCpf();
        this.aircraft = passengers.getAircraft();
    }
}
