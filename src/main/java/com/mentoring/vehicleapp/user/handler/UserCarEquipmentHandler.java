package com.mentoring.vehicleapp.user.handler;

import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.user.User;
import com.mentoring.vehicleapp.user.UserCarEquipmentDTO;
import com.mentoring.vehicleapp.user.UserService;
import com.mentoring.vehicleapp.vehicle.Vehicle;
import com.mentoring.vehicleapp.vehicle.equipment.VehicleEquipment;
import com.mentoring.vehicleapp.vehicle.util.VehicleTypeValidator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserCarEquipmentHandler {

    private final UserService service;

    public UserCarEquipmentHandler(UserService service) {
        this.service = service;
    }

    public List<UserCarEquipmentDTO> findAllWithCarEquipment(String vehicleType) {
        if(VehicleTypeValidator.vehicleTypeExists(vehicleType)) {
            return service.findAllWithCarEquipment().stream().map(this::mapToUserCarEqDTO).collect(Collectors.toList());
        } else throw new IllegalArgumentException("Invalid vehicle type");
    }

    private UserCarEquipmentDTO mapToUserCarEqDTO(User user) {
        UserCarEquipmentDTO userDTO = UserCarEquipmentDTO.builder()
                .name(user.getName())
                .equipment(getEqFromUser(user))
                .build();
        return userDTO;
    }

    private Set<Equipment> getEqFromUser(User user) {
        return user.getVehicles().stream().flatMap(vehicle -> vehicle.getVehicleEquipment().stream()).map(VehicleEquipment::getEquipment).collect(Collectors.toSet());
    }
}
