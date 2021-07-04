package com.shivesh.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivesh.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
