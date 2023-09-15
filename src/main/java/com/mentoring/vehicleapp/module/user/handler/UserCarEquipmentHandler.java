package com.mentoring.vehicleapp.module.user.handler;

import com.mentoring.vehicleapp.module.equipment.Equipment;
import com.mentoring.vehicleapp.module.user.User;
import com.mentoring.vehicleapp.module.vehicle.equipment.VehicleEquipment;
import com.mentoring.vehicleapp.module.user.UserForVehicleTypeEquipmentDTO;
import com.mentoring.vehicleapp.module.user.UserService;
import com.mentoring.vehicleapp.module.user.UserVehicleTypeEquipmentDTO;
import com.mentoring.vehicleapp.module.vehicle.VehicleType;
import com.mentoring.vehicleapp.module.vehicle.util.VehicleTypeValidator;
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

    public List<UserVehicleTypeEquipmentDTO> findAllWithVehicleType(String vehicleType) {
        if(validator.vehicleTypeExists(vehicleType)) {
            //TODO sonar issue
            return service.findAllWithVehicleType(vehicleType.toUpperCase()).stream().map(user -> mapToUserCarEqDTO(user, vehicleType)).collect(Collectors.toList());
        } else throw new IllegalArgumentException("Invalid vehicle type");
    }
    public List<UserForVehicleTypeEquipmentDTO> findAllForVehicleType(String vehicleType) {
        if(validator.vehicleTypeExists(vehicleType)) {
            return service.findAllForVehicleType(vehicleType.toUpperCase());
        } else throw new IllegalArgumentException("Invalid vehicle type");
    }

    private UserVehicleTypeEquipmentDTO mapToUserCarEqDTO(User user, String vehicleType) {
        return UserVehicleTypeEquipmentDTO.builder()
                .name(user.getName())
                .equipment(getEqFromUser(user, vehicleType))
                .build();
    }

    private Set<Equipment> getEqFromUser(User user, String vehicleType) {
        return user.getVehicles().stream()
                .filter(vehicle -> vehicle.getType() == EnumUtils.getEnumIgnoreCase(VehicleType.class ,vehicleType))
                .flatMap(vehicle -> vehicle.getVehicleEquipment().stream())
                .map(VehicleEquipment::getEquipment)
                .collect(Collectors.toSet());
    }
}
