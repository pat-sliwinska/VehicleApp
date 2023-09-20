package com.mentoring.vehicleapp.user.repository;

import com.mentoring.vehicleapp.user.dto.UserVehicleEqTempDTO;

import java.util.List;

public interface UserExtendedRepository {

    List<UserVehicleEqTempDTO> findAllForVehicleType(String vehicleType);
}
