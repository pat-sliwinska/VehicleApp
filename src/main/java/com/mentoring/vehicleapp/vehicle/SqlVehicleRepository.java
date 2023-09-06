package com.mentoring.vehicleapp.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlVehicleRepository extends JpaRepository<Vehicle, Long>, VehicleRepository {
}
