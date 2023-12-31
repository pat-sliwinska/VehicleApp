package com.mentoring.vehicleapp.user;

import com.mentoring.vehicleapp.user.dto.UserForVehicleTypeEquipmentDTO;
import com.mentoring.vehicleapp.user.dto.UserVehicleTypeEquipmentDTO;
import com.mentoring.vehicleapp.user.handler.UserCarEquipmentHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;
    private final UserCarEquipmentHandler userCarEquipmentHandler;

    public UserController(UserService service, UserCarEquipmentHandler handler) {
        this.service = service;
        this.userCarEquipmentHandler = handler;
    }

    @GetMapping
    List<User> readAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> readUserById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/equipment/{vehicleType}")
    List<UserVehicleTypeEquipmentDTO> readUserWithVehicleTypeEquipment(@PathVariable String vehicleType) {
        return userCarEquipmentHandler.findAllWithVehicleType(vehicleType);
    }
    @GetMapping("/equipmentDto/{vehicleType}")
    List<UserForVehicleTypeEquipmentDTO> readUserForVehicleTypeEquipment(@PathVariable String vehicleType) {
        return userCarEquipmentHandler.findAllForVehicleType(vehicleType);
    }

    @PostMapping
    User addUser(@RequestBody User user) {
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        service.deleteById(id);
    }
}
