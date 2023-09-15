package com.mentoring.vehicleapp.module.vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {

    Vehicle save(Vehicle vehicle);

    List<Vehicle> findAll();

    Optional<Vehicle> findById(Long id);

    void deleteById(Long id);
}
