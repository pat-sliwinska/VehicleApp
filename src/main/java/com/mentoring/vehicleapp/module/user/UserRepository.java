package com.mentoring.vehicleapp.module.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    List<User> findAll();

    List<User> findAllWithVehicleType(String vehicleType);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
