package com.mentoring.vehicleapp.user.dto;

import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserVehicleEqTempDTO {

    private Long id;
    private User user;
    private Equipment equipment;
}
