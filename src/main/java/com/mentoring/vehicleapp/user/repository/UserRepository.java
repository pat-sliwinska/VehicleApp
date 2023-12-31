package com.mentoring.vehicleapp.user.repository;

import com.mentoring.vehicleapp.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);

    List<User> findAll();

    List<User> findAllWithVehicleType(String vehicleType);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
