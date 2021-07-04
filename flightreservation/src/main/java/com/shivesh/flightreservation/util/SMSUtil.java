package com.shivesh.flightreservation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.shivesh.flightreservation.entities.Reservation;
import com.twilio.Twilio;

/**
 * @author shive
 *
 */
@Component
public class SMSUtil {

	@Value("${com.shivesh.flightreservation.itinerary.sms.account.sid}")
	public  String ACCOUNT_SID;
	@Value("${com.shivesh.flightreservation.itinerary.sms.auth.token}")
	public  String AUTH_TOKEN;
	@Value("${com.shivesh.flightreservation.itinerary.sms.twilio.phone.number}")
	public String TWILIO_NUMBER;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SMSUtil.class);
	
	/**
	 * @param toPhoneNumber
	 */
	public void sendSMS(PhoneNumber toPhoneNumber,Reservation reservation ) {
		LOGGER.info("Inside sendSMS(), Phone Number: {}",toPhoneNumber);
		try {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(toPhoneNumber,
		        new PhoneNumber(TWILIO_NUMBER), 
		        "\n\nWeb Development Tools and Methods Project \nFlight Tickect details-\nPassenger Name:"
		        +reservation.getPassenger().getFirstName()+" "+reservation.getPassenger().getLastName()
		        +"\nPNR: WDTAM"+reservation.getId()).create();
		    LOGGER.info("Message Sent: { }",message);
		}catch(Exception exception) {
			 LOGGER.error("Exception occured insdie senSMS: {}",exception);
		}
	}
}
