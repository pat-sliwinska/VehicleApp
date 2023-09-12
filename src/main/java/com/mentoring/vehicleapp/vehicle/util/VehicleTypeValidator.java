package com.mentoring.vehicleapp.vehicle.util;

import com.mentoring.vehicleapp.vehicle.VehicleType;
import org.apache.commons.lang3.EnumUtils;

public class VehicleTypeValidator {

    public static boolean vehicleTypeExists(String stringToCheck) {
        return EnumUtils.isValidEnumIgnoreCase(VehicleType.class, stringToCheck);
    }
}
