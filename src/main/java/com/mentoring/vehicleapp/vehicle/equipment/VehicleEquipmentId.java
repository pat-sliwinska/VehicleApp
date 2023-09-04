package com.mentoring.vehicleapp.vehicle.equipment;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VehicleEquipmentId implements Serializable {

    private Long vehicleId;
    private Long equipmentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEquipmentId that = (VehicleEquipmentId) o;
        return vehicleId.equals(that.vehicleId) && equipmentId.equals(that.equipmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, equipmentId);
    }
}
