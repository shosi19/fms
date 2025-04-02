package com.sopra.fmsbackend.model;

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
public class Airport {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String code;

    
    @Column
    private String name;

   
    @Column
    private String city;

   
    @Column
    private String country;

    public Long getId() {
  		return id;
  	}


  	public void setId(Long id) {
  		this.id = id;
  	}


  	public String getCode() {
  		return code;
  	}


  	public void setCode(String code) {
  		this.code = code;
  	}


  	public String getName() {
  		return name;
  	}


  	public void setName(String name) {
  		this.name = name;
  	}


  	public String getCity() {
  		return city;
  	}


  	public void setCity(String city) {
  		this.city = city;
  	}


  	public String getCountry() {
  		return country;
  	}


  	public void setCountry(String country) {
  		this.country = country;
  	}	


    
}
