package com.sopra.fmsbackend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.fmsbackend.model.Airport;
import com.sopra.fmsbackend.service.AirportService;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

	@Autowired
	private AirportService service;
	private static final Logger log = LoggerFactory.getLogger(AirportController.class);

	@GetMapping
	public List<Airport> getAllAirports() {
		log.debug("inside getAllAirport Controller method");
		return service.getAllAirports();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
		log.debug("inside getAirportById Controller method");
		Airport airport = service.getAirport(id);
		return ResponseEntity.ok(airport);

	}

	@PostMapping
	public Airport createAirport(@RequestBody Airport airport) {
		log.debug("inside createAirport Controller method");
		return service.saveAirport(airport);
	}

	@PutMapping("/{id}")
	public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
		log.debug("inside updateAirport Controller method");
		airport.setId(id);
		return service.saveAirport(airport);
	}

	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable Long id) {
		log.debug("inside deleteAirport Controller method");
		service.deleteAirport(id);
	}

}
