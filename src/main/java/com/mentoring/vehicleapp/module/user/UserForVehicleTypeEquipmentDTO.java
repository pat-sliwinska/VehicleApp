package com.mentoring.vehicleapp.module.user;

import com.mentoring.vehicleapp.module.equipment.Equipment;
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
