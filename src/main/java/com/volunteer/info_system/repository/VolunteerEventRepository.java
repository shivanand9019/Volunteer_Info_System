package com.volunteer.info_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.info_system.entity.VolunteerEvent;

public interface VolunteerEventRepository extends JpaRepository<VolunteerEvent,Long>{
    
}
