package com.sopra.fmsbackend.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.fmsbackend.exception.ResourceNotFoundException;
import com.sopra.fmsbackend.model.Booking;
import com.sopra.fmsbackend.repository.BookingRepository;


@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    public List <Booking> getAllBookings(){
        return repository.findAll();
    }

    public Booking getBooking(Long id){

        log.debug("inside geBooking");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking not found with id: " + id));
        
    }

    public Booking saveBooking(Booking booking) {

        return repository.save(booking);
    }

    public void deleteBooking(Long id) {
        
        repository.deleteById(id);
    }

    public List<Booking> getBookingWithStatus(String status){

        log.debug("inside geBookingWithStatus");
        return repository.getBookingsWithStatus(status);
        
    }
    
}
