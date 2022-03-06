package com.airpollution.repo;

import com.airpollution.entities.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegistrationRepo extends JpaRepository<RegistrationEntity, Integer> {

    @Query(value = "SELECT COUNT(*) FROM registration WHERE registration.username = :username", nativeQuery = true)
    Integer checkIfUserExists(@Param("username") String username);

}
