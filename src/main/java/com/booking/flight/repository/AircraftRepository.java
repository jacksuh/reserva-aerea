package com.booking.flight.repository;
import com.booking.flight.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}
