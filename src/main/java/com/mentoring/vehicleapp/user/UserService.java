package com.mentoring.vehicleapp.user;

import com.mentoring.vehicleapp.user.dto.UserVehicleEqTempDTO;
import com.mentoring.vehicleapp.user.repository.UserExtendedRepository;
import com.mentoring.vehicleapp.user.repository.UserRepository;
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

    public List<User> findAllWithVehicleType(String vehicleType) {return repository.findAllWithVehicleType(vehicleType);}
    public List<UserVehicleEqTempDTO> findAllForVehicleType(String vehicleType) {return extendedRepository.findAllForVehicleType(vehicleType);}

    Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
