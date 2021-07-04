package com.shivesh.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailsService userDetailService;
	
	@Autowired
	AuthenticationManager  authenticationManager;
	
	@Override
	public boolean login(String username, String password) {
		UserDetails userDetails = userDetailService.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, 
				password,userDetails.getAuthorities());
		
		authenticationManager.authenticate(token);
		
		boolean result = token.isAuthenticated();
		
		if(result) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return result;
	}

}
