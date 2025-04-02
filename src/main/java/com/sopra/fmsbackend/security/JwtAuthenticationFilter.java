package com.sopra.fmsbackend.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);

	@Autowired
	JwtHelper jwtHelper;

	@Autowired
	UserDetailsService userDetailService;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//HttpServletResponse response = (HttpServletResponse) res;
        //HttpServletRequest request = (HttpServletRequest) req;
 
		/*
		 * response.setHeader("Access-Control-Allow-Origin",
		 * "http://20.160.136.4:3000");
		 * response.setHeader("Access-Control-Allow-Methods",
		 * "GET, POST, PUT, DELETE, OPTIONS");
		 * response.setHeader("Access-Control-Allow-Headers",
		 * "Content-Type, Authorization");
		 * response.setHeader("Access-Control-Allow-Credentials", "true");
		 */
 
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
        	String requestHeader = request.getHeader("Authorization");
    		logger.info("request : " + request.toString());
    		logger.info("Header : " + requestHeader);

    		String username = null;
    		String token = null;

    		if (null != requestHeader && requestHeader.startsWith("Bearer")) {

    			token = requestHeader.substring(7);

    			try {

    				username = jwtHelper.getUsernameFromToken(token);
    			} catch (IllegalArgumentException e) {
    				logger.info("Illegal Argument while fetching the username !!");
    				e.printStackTrace();
    			} catch (ExpiredJwtException e) {
    				logger.info("Given jwt token is expired !!");
    				e.printStackTrace();
    			} catch (MalformedJwtException e) {
    				logger.info("Some changed has done in token !! Invalid Token");
    				e.printStackTrace();
    			} catch (Exception e) {
    				e.printStackTrace();

    			}

    		}

    		else {
    			logger.info("Invalid Header");

    		}

    		if (null != username && SecurityContextHolder.getContext().getAuthentication() == null) {

    			UserDetails userDetails = this.userDetailService.loadUserByUsername(username);
    			Boolean validToken = this.jwtHelper.validateToken(token, userDetails);

    			if (validToken) {
    				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
    						userDetails, null, userDetails.getAuthorities());
    				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    				SecurityContextHolder.getContext().setAuthentication(authentication);
    			} else {
    				logger.info("Validation Failed!");

    			}
    		}

    		filterChain.doFilter(request, response);
            //chain.doFilter(req, res);
        }

		
	}

}
