package com.volunteer.info_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.info_system.entity.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer,Long>{

    
}