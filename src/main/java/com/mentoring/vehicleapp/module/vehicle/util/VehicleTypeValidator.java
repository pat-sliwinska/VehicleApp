package com.mentoring.vehicleapp.module.vehicle.util;

import com.mentoring.vehicleapp.module.vehicle.VehicleType;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

@Component
public class VehicleTypeValidator {

    public boolean vehicleTypeExists(String stringToCheck) {
        return EnumUtils.isValidEnumIgnoreCase(VehicleType.class, stringToCheck);
    }
}
