package com.sopra.fmsbackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Schedule {


  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;
    
    public long getId() {
  		return id;
  	}

  	public void setId(long id) {
  		this.id = id;
  	}

  	public LocalDateTime getDepartureTime() {
  		return departureTime;
  	}

  	public void setDepartureTime(LocalDateTime departureTime) {
  		this.departureTime = departureTime;
  	}

  	public LocalDateTime getArrivalTime() {
  		return arrivalTime;
  	}

  	public void setArrivalTime(LocalDateTime arrivalTime) {
  		this.arrivalTime = arrivalTime;
  	}

  	public Airport getDepartureAirport() {
  		return departureAirport;
  	}

  	public void setDepartureAirport(Airport departureAirport) {
  		this.departureAirport = departureAirport;
  	}

  	public Airport getArrivalAirport() {
  		return arrivalAirport;
  	}

  	public void setArrivalAirport(Airport arrivalAirport) {
  		this.arrivalAirport = arrivalAirport;
  	}

}
