package com.airpollution.repo;

import com.airpollution.entities.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<RegistrationEntity, Integer> {
    @Query(value = "SELECT password FROM registration WHERE username = :username", nativeQuery = true)
    String findPasswordByUsername(@Param("username") String username);
}
