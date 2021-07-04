package com.shivesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivesh.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
