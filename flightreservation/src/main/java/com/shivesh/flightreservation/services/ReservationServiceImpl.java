package com.shivesh.flightreservation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivesh.flightreservation.dto.ReservationRequest;
import com.shivesh.flightreservation.entities.Flight;
import com.shivesh.flightreservation.entities.Passenger;
import com.shivesh.flightreservation.entities.Reservation;
import com.shivesh.flightreservation.repos.FlightRepository;
import com.shivesh.flightreservation.repos.PassengerRepository;
import com.shivesh.flightreservation.repos.ReservationRepository;
import com.shivesh.flightreservation.util.EmailUtil;
import com.shivesh.flightreservation.util.PDFGenerator;
import com.shivesh.flightreservation.util.SMSUtil;
import com.twilio.type.PhoneNumber;


/**
 * @author shive
 *
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.shivesh.flightreservation.itinerary.dirpath}")
	private String ITINERARY_DIR;

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	SMSUtil smsUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	/**
	 *@param ReservationRequest
	 *@return Reservation
	 */
	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight()");
		//Make Payment
		
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flight for flight id: "+flightId);
		Flight flight = flightRepository.findOne(flightId);
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the passenger:"+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		LOGGER.info("Saving the reservation:"+reservation);
		Reservation savedResevation = reservationRepository.save(reservation);
		
		String filePath = ITINERARY_DIR+savedResevation.getId()+".pdf";
		LOGGER.info("Generating the Itinerary");
		pdfGenerator.generateItinerary(savedResevation, filePath);
		LOGGER.info("Emailing the Itinerary");
		emailUtil.sendItinerary(passenger.getEmail(), filePath);
		LOGGER.info("Sending the Itinerary SMS");
		smsUtil.sendSMS( new PhoneNumber(passenger.getPhone()),savedResevation);
		
		return savedResevation;
	}

}
