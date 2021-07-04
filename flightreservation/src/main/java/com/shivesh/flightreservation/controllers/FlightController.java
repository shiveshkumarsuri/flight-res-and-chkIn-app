package com.shivesh.flightreservation.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shivesh.flightreservation.entities.Flight;
import com.shivesh.flightreservation.repos.FlightRepository;

/**
 * @author shive
 *
 */
@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	/**
	 * @param from
	 * @param to
	 * @param departureDate
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("findFlights")
	public String fingflights(@RequestParam("from")String from,@RequestParam("to")String to,
			@RequestParam("departureDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,ModelMap modelMap) {
		
		LOGGER.info("Inside fingflights() From:"+from +" TO:"+to+" Departure Date:" + departureDate);
		List<Flight> flights = flightRepository.findFlights(from,to,departureDate);
		modelMap.addAttribute("flights",flights);
		LOGGER.info("Flights found are:"+ flights);
		return "displayFlights";
	}
	
	/**
	 * @return view name
	 */
	@RequestMapping("/addFlight")
	public String showAddFlight() {
		
		return "addFlight";
	}
	
	/**
	 * @param flightNumber
	 * @param operatingAirline
	 * @param departureCity
	 * @param arrivalCity
	 * @param departureDate
	 * @param estimatedDepartureTime
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "addNewFlight", method = RequestMethod.POST)
	public String register(@RequestParam("flightNumber") String flightNumber,
			@RequestParam("operatingAirline") String operatingAirline,
			@RequestParam("departureCity")String departureCity,@RequestParam("arrivalCity")String arrivalCity,
			@RequestParam("departureDate")@DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
			@RequestParam("estimatedDepartureTime")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date estimatedDepartureTime,
			ModelMap modelMap) {
		Flight flight = new Flight();
		flight.setFlightNumber(flightNumber);
		flight.setOperatingAirlines(operatingAirline);
		flight.setDepartureCity(departureCity);
		flight.setArrivalCity(arrivalCity);

		flight.setDateOfDeparture(departureDate);
	    
		flight.setEstimatedDepartureTime(new Timestamp(estimatedDepartureTime.getTime()));
		modelMap.addAttribute("flight",flight);
		LOGGER.info("Inside addNewFlight()"+ flight);
		flightRepository.save(flight);
		return "flightAdded";
	}
	
	/**
	 * @param term
	 * @return
	 */
	@RequestMapping("/fromautocomplete")
	@ResponseBody
	public List<String> fromAutocomplete(@RequestParam(value="term",required=false, defaultValue="")String term){
		List<String> froms = flightRepository.findDepartCity(term);
		List<String> fromList = new ArrayList<String>();
		for (String city : froms) {
			if(!fromList.contains(city))
			fromList.add(city);
		}
		return fromList;
	}
	
	/**
	 * @param term
	 * @return
	 */
	@RequestMapping("/toautocomplete")
	@ResponseBody
	public List<String> toAutocomplete(@RequestParam(value="term",required=false, defaultValue="")String term){
		List<String> tos = flightRepository.findArrivalCity(term);
		List<String> toList = new ArrayList<String>();
		for (String city : tos) {
			if(!toList.contains(city))
				toList.add(city);
		}
		return toList;
	}
}
