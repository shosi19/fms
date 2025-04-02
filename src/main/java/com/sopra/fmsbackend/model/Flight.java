package com.sopra.fmsbackend.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Flight {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@Column(nullable = false, unique = true)
    private BigInteger flightNo;

   
    @Column(nullable = false)
    private String carrierName;

   
    @Column(nullable = false)
    private String flightModel;

    
    @Column(nullable = false)
    private int seatCapacity;
    
    
    public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public BigInteger getFlightNo() {
		return flightNo;
	}


	public void setFlightNo(BigInteger flightNo) {
		this.flightNo = flightNo;
	}


	public String getCarrierName() {
		return carrierName;
	}


	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}


	public String getFlightModel() {
		return flightModel;
	}


	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}


	public int getSeatCapacity() {
		return seatCapacity;
	}


	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
    
}
