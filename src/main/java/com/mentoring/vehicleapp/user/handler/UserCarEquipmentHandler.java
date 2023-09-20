package com.mentoring.vehicleapp.user.handler;

import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.user.User;
import com.mentoring.vehicleapp.user.dto.UserForVehicleTypeEquipmentDTO;
import com.mentoring.vehicleapp.user.dto.UserVehicleEqTempDTO;
import com.mentoring.vehicleapp.user.dto.UserVehicleTypeEquipmentDTO;
import com.mentoring.vehicleapp.user.UserService;
import com.mentoring.vehicleapp.vehicle.VehicleType;
import com.mentoring.vehicleapp.vehicle.equipment.VehicleEquipment;
import com.mentoring.vehicleapp.vehicle.util.VehicleTypeValidator;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
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
            return service.findAllWithVehicleType(vehicleType.toUpperCase()).stream()
                    .map(user -> mapToUserCarEqDTO(user, vehicleType))
                    .collect(Collectors.toList());
        } else throw new IllegalArgumentException("Invalid vehicle type");
    }
    public List<UserForVehicleTypeEquipmentDTO> findAllForVehicleType(String vehicleType) {
        if(validator.vehicleTypeExists(vehicleType)) {
             return mapTempDTOToUserCarEqDTO(service.findAllForVehicleType(vehicleType.toUpperCase()));
        } else throw new IllegalArgumentException("Invalid vehicle type");
    }

    private List<UserForVehicleTypeEquipmentDTO> mapTempDTOToUserCarEqDTO(List<UserVehicleEqTempDTO> temporaryDTOList) {
        List<UserForVehicleTypeEquipmentDTO> dtoList = new ArrayList<>();
        temporaryDTOList.forEach(result -> {
            if(dtoList.stream().anyMatch(dto -> dto.getId().equals(result.getId()))) {
                UserForVehicleTypeEquipmentDTO existingDto = dtoList.stream()
                        .filter(dto -> dto.getId().equals(result.getId()))
                        .findFirst()
                        .get();
                existingDto.getEquipment().add(result.getEquipment());
            } else {
                UserForVehicleTypeEquipmentDTO newDto = UserForVehicleTypeEquipmentDTO.builder()
                        .id(result.getId())
                        .name(result.getUser().getName())
                        .equipment(new HashSet<>())
                        .build();
                newDto.getEquipment().add(result.getEquipment());
                dtoList.add(newDto);
            }
        });

        return dtoList;
    }

    private UserVehicleTypeEquipmentDTO mapToUserCarEqDTO(User user, String vehicleType) {
        return UserVehicleTypeEquipmentDTO.builder()
                .name(user.getName())
                .equipment(getEqFromUser(user, vehicleType))
                .build();
    }

    private Set<Equipment> getEqFromUser(User user, String vehicleType) {
        return user.getVehicles().stream().filter(vehicle -> vehicle.getType() == EnumUtils.getEnumIgnoreCase(VehicleType.class ,vehicleType)).flatMap(vehicle -> vehicle.getVehicleEquipment().stream()).map(VehicleEquipment::getEquipment).collect(Collectors.toSet());
    }
}
