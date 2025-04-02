package com.sopra.fmsbackend.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.fmsbackend.model.JwtRequest;
import com.sopra.fmsbackend.model.JwtResponse;
import com.sopra.fmsbackend.security.JwtHelper;



@RestController
@RequestMapping("/api/fmsSecurity")
public class SecurityController {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtHelper helper;
	
	/*
	 * @Autowired private HttpRequest request;
	 */

	private Logger logger = LoggerFactory.getLogger(SecurityController.class);

	@GetMapping("/check")
	public String healthCheck() {

		return "Status : Running";

	}

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		
		this.doAuthenticate(request.getUsername(), request.getPassword());

		logger.info(request.toString());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = new JwtResponse(); // Assuming a no-argument constructor
        response.setJwtToken(token);
        response.setUserName(userDetails.getUsername());
    
        return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/currentUser")
	public String getCurrentUser(Principal principal) {
		return principal.getName();
		
	}
	
	@GetMapping("/validateToken")
	public Boolean validateToken() {
		
		String jwt= "";// request.getHeaders().get("Authorization").toString();
		
		System.out.println(jwt);
		
		return true;
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}
	
	 @ExceptionHandler(BadCredentialsException.class)
	    public ResponseEntity<JwtResponse> exceptionHandler() {
		 JwtResponse response = new JwtResponse();
		 response.setJwtToken(null);
		 response.setErrorMsg("Invalid Credentials");

	     return new ResponseEntity<>(response, HttpStatus.OK);
	    }
}
