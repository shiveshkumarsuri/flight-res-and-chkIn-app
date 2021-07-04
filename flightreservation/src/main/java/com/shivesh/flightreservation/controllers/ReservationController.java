package com.shivesh.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivesh.flightreservation.dto.ReservationRequest;
import com.shivesh.flightreservation.entities.Flight;
import com.shivesh.flightreservation.entities.Reservation;
import com.shivesh.flightreservation.repos.FlightRepository;
import com.shivesh.flightreservation.services.ReservationService;

/**
 * @author shive
 *
 */
@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	/**
	 * @param flightId
	 * @param modelMap
	 * @return pageName
	 */
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() invoked with flight id:" + flightId);
		Flight flight = flightRepository.findOne(flightId);
		modelMap.addAttribute("flight", flight);
		LOGGER.info("Flight is:" + flight);
		return "completeReservation";
	}
	
	/**
	 * @param request
	 * @param modelMap
	 * @return pageName
	 */
	@RequestMapping(value="/completeReservation",method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() " + request);
		try {
			Reservation reservation = reservationService.bookFlight(request);
			modelMap.addAttribute("msg",reservation.getId());
		}catch(Exception exception) {
			modelMap.addAttribute("msg","All fields are manadatory!");
		}
		return "reservationConfirmation";
		
	}
	
	
}
