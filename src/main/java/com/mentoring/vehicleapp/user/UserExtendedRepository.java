package com.mentoring.vehicleapp.user;

import java.util.List;

public interface UserExtendedRepository {

    public List<UserForVehicleTypeEquipmentDTO> findAllForVehicleType(String vehicleType);
}
