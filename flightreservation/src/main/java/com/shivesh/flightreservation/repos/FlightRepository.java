package com.shivesh.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivesh.flightreservation.entities.Flight;


/**
 * @author shive
 *
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity")String from, @Param("arrivalCity")String to, 
			@Param("dateOfDeparture")Date departureDate);
	
	@Query("select f.departureCity from Flight f where departureCity like concat('%',:term,'%')")
	List<String> findDepartCity(@Param("term")String term);

	@Query("select f.arrivalCity from Flight f where arrivalCity like concat('%',:term,'%')")
	List<String> findArrivalCity(@Param("term")String term);
}
