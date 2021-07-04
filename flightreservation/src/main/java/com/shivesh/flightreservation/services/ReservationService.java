package com.shivesh.flightreservation.services;

import com.shivesh.flightreservation.dto.ReservationRequest;
import com.shivesh.flightreservation.entities.Reservation;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}
