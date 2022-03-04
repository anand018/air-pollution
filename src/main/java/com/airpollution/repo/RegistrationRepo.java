package com.airpollution.repo;

import com.airpollution.entities.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Integer> {
    
}
