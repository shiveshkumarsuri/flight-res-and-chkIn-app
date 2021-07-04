package com.shivesh.flightcheckin.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivesh.flightcheckin.integration.ReservationRestClient;
import com.shivesh.flightcheckin.integration.dto.Reservation;
import com.shivesh.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckInController {

	@Autowired
	ReservationRestClient reservationRestClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckInController.class);

	
	@RequestMapping("/showStartCheckIn")
	public String startCheckIn() {
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId")Long reservationId, ModelMap modelMap) {
		LOGGER.info("Inside startCheckIn(), reservation id: {}",reservationId);
		Reservation reservation = reservationRestClient.findReservation(reservationId);
		if(reservation == null) {
			modelMap.addAttribute("msg", "Sorry! No reservation found.");
		}else {
			modelMap.addAttribute("reservation",reservation);
		}
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId")Long reservationId,
			@RequestParam("numberOfBags")int numberOfBags) {
		
		LOGGER.info("Inside completeCheckIn(), numberOfBags {}",numberOfBags);
		ReservationUpdateRequest request = new ReservationUpdateRequest();
		request.setId(reservationId);
		request.setCheckedIn(true);
		request.setNumberOfBags(numberOfBags);
		
		reservationRestClient.updateReservation(request);
		return "checkInConfirmation";
	}
}
