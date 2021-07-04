package com.shivesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivesh.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
