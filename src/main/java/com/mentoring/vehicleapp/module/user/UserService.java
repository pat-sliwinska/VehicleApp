package com.mentoring.vehicleapp.module.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserExtendedRepository extendedRepository;

    public UserService(UserRepository userRepository, UserExtendedRepository extendedRepository) {
        this.repository = userRepository;
        this.extendedRepository = extendedRepository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> findAllWithVehicleType(String vehicleType) {
        return repository.findAllWithVehicleType(vehicleType);
    }

    public List<UserForVehicleTypeEquipmentDTO> findAllForVehicleType(String vehicleType) {
        return extendedRepository.findAllForVehicleType(vehicleType);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
