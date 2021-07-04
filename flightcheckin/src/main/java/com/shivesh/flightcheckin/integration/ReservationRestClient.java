package com.shivesh.flightcheckin.integration;

import com.shivesh.flightcheckin.integration.dto.Reservation;
import com.shivesh.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest request);

}
