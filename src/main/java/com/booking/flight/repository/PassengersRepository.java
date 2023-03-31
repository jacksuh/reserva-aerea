package com.booking.flight.repository;
import com.booking.flight.model.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PassengersRepository extends JpaRepository<Passengers, Long> {
}
