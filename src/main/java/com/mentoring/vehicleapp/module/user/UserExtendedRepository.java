package com.mentoring.vehicleapp.module.user;

import java.util.List;

public interface UserExtendedRepository {

    public List<UserForVehicleTypeEquipmentDTO> findAllForVehicleType(String vehicleType);
}
