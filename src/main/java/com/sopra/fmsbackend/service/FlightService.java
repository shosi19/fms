package com.sopra.fmsbackend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.fmsbackend.exception.ResourceNotFoundException;
import com.sopra.fmsbackend.model.Flight;
import com.sopra.fmsbackend.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository repository;
	private static final Logger log = LoggerFactory.getLogger(FlightService.class);

	public List<Flight> getAllFlight() {
		return repository.findAll();
	}

	public Flight geFlight(Long id) {

		log.debug("inside getFlight");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Flight not found with id: " + id));

	}

	public Flight saveFlight(Flight flight) {

		return repository.save(flight);
	}

	public void deleteFlight(Long id) {

		repository.deleteById(id);
	}
}
