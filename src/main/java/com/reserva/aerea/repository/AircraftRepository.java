package com.reserva.aerea.repository;
import com.reserva.aerea.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

}
