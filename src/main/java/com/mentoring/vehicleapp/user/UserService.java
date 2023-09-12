package com.mentoring.vehicleapp.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public User save(User user) {
        return repository.save(user);
    }

//    public List<User> findAll() {
//        return repository.findAll();
//    }

    public List<User> findAll() {
        return repository.x();
    }

    public List<User> findAllWithCarEquipment() {return repository.findAllWithCarEquipment();}

    Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
