package com.mentoring.vehicleapp.user.dto;

import com.mentoring.vehicleapp.equipment.Equipment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UserForVehicleTypeEquipmentDTO {

    private Long id;
    private String name;
    private Set<Equipment> equipment;

}
