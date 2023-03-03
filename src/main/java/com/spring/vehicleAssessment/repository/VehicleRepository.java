package com.spring.vehicleAssessment.repository;

import com.spring.vehicleAssessment.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE v.isActive=:active")
    List<Vehicle> findByIsActive(@Param("active") Boolean active);
}
