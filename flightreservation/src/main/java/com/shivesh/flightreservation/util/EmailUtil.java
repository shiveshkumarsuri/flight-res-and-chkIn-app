package com.shivesh.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


/**
 * @author shive
 *
 */
@Component
public class EmailUtil {
	
	@Value("${com.shivesh.flightreservation.itinerary.email.body}")
	private String EMAIL_BODY;

	@Value("${com.shivesh.flightreservation.itinerary.email.subject}")
	private  String EMAIL_SUBJECT;

	@Autowired
	public JavaMailSender sender;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
  
	/**
	 * @param toAddress
	 * @param filePath
	 */
	public void sendItinerary(String toAddress,String filePath) {
		
		LOGGER.info("Inside sendItinerary()");
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(EMAIL_SUBJECT);
			messageHelper.setText(EMAIL_BODY);
			messageHelper.addAttachment("Itinerary", new File(filePath));
			sender.send(message);
			
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sendItinerary:"+ e);
		}
	}
}
