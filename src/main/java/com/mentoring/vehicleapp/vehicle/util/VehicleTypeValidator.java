package com.mentoring.vehicleapp.vehicle.util;

import com.mentoring.vehicleapp.vehicle.VehicleType;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Component;

@Component
public class VehicleTypeValidator {

    public boolean vehicleTypeExists(String stringToCheck) {
        return EnumUtils.isValidEnumIgnoreCase(VehicleType.class, stringToCheck);
    }
}
