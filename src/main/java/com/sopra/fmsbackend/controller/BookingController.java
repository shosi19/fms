package com.sopra.fmsbackend.controller;

import java.util.List;

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

import com.sopra.fmsbackend.model.Booking;
import com.sopra.fmsbackend.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingService service;

	@GetMapping
	public List<Booking> getAllBookings() {
		return service.getAllBookings();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getFlightById(@PathVariable Long id) {
		Booking booking = service.getBooking(id);
		return ResponseEntity.ok(booking);

	}

	@PostMapping
	public Booking createFlight(@RequestBody Booking booking) {
		return service.saveBooking(booking);
	}

	@PutMapping("/{id}")
	public Booking updateFlight(@PathVariable Long id, @RequestBody Booking booking) {
		booking.setId(id);
		return service.saveBooking(booking);
	}

	@DeleteMapping("/{id}")
	public void deleteFlight(@PathVariable Long id) {
		service.deleteBooking(id);
	}

	@GetMapping("/bookingStatus/{status}")
	public ResponseEntity<List<Booking>> getBookingWithStatus(@PathVariable String status) {
		List<Booking> bookings = service.getBookingWithStatus(status);
		return ResponseEntity.ok(bookings);

	}

}
