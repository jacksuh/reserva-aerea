package com.booking.flight.service;
import com.booking.flight.model.Flight;
import com.booking.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class FlightService {
    @Autowired
    private FlightRepository repository;

    public Page<Flight> getAll(Pageable page) {
        return repository.findAll(page);
    }

}

