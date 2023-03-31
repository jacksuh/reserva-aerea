/**package com.reserva.aerea.model;
import com.reserva.aerea.dao.AirplaneData;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "aviao")
@Entity(name = "Aviao")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Airplane extends Aircraft{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Passengers[][] place;

    private int ranks;
    private int seats;

    public Airplane(String model, int ranks, int seats,Passengers passengers, int rankspassenger, int seatspassenger) {
        super(model);
        this.place = new Passengers[ranks][seats];
    }



    public boolean occupiedSeat(int ranks, int seats){
        return this.place[ranks][seats] != null;
    }

    public Passengers getPassengers(int ranks, int seats){
        return this.place[ranks][seats];
    }

    public void setPassengers(int ranks, int seats, Passengers passengers){
        this.place[ranks][seats] = passengers;
    }

    public Airplane(AirplaneData data){
        super(data.getModel());
        setPassengers(data.getRankspassenger(), data.getSeatspassenger(), data.getPassengers());
    }

}
**/