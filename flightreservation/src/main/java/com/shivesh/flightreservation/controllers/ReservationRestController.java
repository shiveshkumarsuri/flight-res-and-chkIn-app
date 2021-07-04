package com.shivesh.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivesh.flightreservation.dto.ReservationUpdateRequest;
import com.shivesh.flightreservation.entities.Reservation;
import com.shivesh.flightreservation.repos.ReservationRepository;

/**
 * @author shive
 *
 */
@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		LOGGER.info("Inside findReservation() for id: "+ id);
		return reservationRepository.findOne(id); 	
	}
	
	/**
	 * @param request
	 * @return
	 */
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updateReservation() for "+request);
		Reservation reservation = reservationRepository.findOne(request.getId());
		
		reservation.setNoOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);
		 
	}
}
