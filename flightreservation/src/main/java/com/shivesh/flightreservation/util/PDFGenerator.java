package com.shivesh.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.shivesh.flightreservation.entities.Reservation;

@Component
public class PDFGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);
	
	@Value("${com.shivesh.flightreservation.itinerary.imagepath}")
	private String IMAGE_PATH;
	
	public void generateItinerary(Reservation reservation, String filePath) {
		LOGGER.info("Inside generateItinerary()");
		Document document= new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			   String filename = IMAGE_PATH;
	            Image image = Image.getInstance(filename);
	            image.scaleAbsolute(595,200);
	            document.add(image);
			document.add(generateTable(reservation));
			document.close();
			
		} catch (FileNotFoundException e) {
			LOGGER.error("Exception inside generateItinerary:"+ e);
		} catch (DocumentException e) {
			LOGGER.error("Exception inside generateItinerary:"+ e);
		} catch (MalformedURLException e) {
			LOGGER.error("Exception inside generateItinerary:"+ e);
		} catch (IOException e) {
			LOGGER.error("Exception inside generateItinerary:"+ e);
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Departure Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Departure Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
	}
}
