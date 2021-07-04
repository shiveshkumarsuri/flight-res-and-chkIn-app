package com.shivesh.flightcheckin.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.shivesh.flightcheckin.integration.dto.Reservation;
import com.shivesh.flightcheckin.integration.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Value("${com.shivesh.flightreservation.client}")
	private String RESERVATION_REST_URL;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestClientImpl.class);


	@Override
	public Reservation findReservation(Long id) {
		LOGGER.info("Inside findReservation method, reservation Id={}",id);
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL+id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		
		Reservation reservation = restTemplate.postForObject(RESERVATION_REST_URL, request, Reservation.class);
		return reservation;
	}

}
