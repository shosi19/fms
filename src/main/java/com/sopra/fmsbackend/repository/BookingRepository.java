package com.sopra.fmsbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.fmsbackend.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {


    String bookingStatusQuery = "SELECT * FROM BOOKING WHERE STATUS = 'Confirmed'";

    @Query(value = "SELECT * FROM BOOKING WHERE STATUS = :status", nativeQuery = true)
    List<Booking> getBookingsWithStatus(@Param("status") String status);
    



    
}
