package com.mentoring.vehicleapp.user.handler;

import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.user.User;
import com.mentoring.vehicleapp.user.UserCarEquipmentDTO;
import com.mentoring.vehicleapp.user.UserService;
import com.mentoring.vehicleapp.vehicle.VehicleType;
import com.mentoring.vehicleapp.vehicle.equipment.VehicleEquipment;
import com.mentoring.vehicleapp.vehicle.util.VehicleTypeValidator;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserCarEquipmentHandler {

    private final UserService service;
    private final VehicleTypeValidator validator;

    public UserCarEquipmentHandler(UserService service, VehicleTypeValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    public List<UserCarEquipmentDTO> findAllWithVehicleType(String vehicleType) {
        if(validator.vehicleTypeExists(vehicleType)) {
            return service.findAllWithVehicleType(vehicleType.toUpperCase()).stream().map(user -> mapToUserCarEqDTO(user, vehicleType)).collect(Collectors.toList());
        } else throw new IllegalArgumentException("Invalid vehicle type");
    }

    private UserCarEquipmentDTO mapToUserCarEqDTO(User user, String vehicleType) {
        UserCarEquipmentDTO userDTO = UserCarEquipmentDTO.builder()
                .name(user.getName())
                .equipment(getEqFromUser(user, vehicleType))
                .build();
        return userDTO;
    }

    private Set<Equipment> getEqFromUser(User user, String vehicleType) {
        return user.getVehicles().stream().filter(vehicle -> vehicle.getType() == EnumUtils.getEnumIgnoreCase(VehicleType.class ,vehicleType)).flatMap(vehicle -> vehicle.getVehicleEquipment().stream()).map(VehicleEquipment::getEquipment).collect(Collectors.toSet());
    }
}
