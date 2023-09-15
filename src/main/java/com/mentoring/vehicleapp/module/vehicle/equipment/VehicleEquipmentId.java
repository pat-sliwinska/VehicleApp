package com.mentoring.vehicleapp.module.vehicle.equipment;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class VehicleEquipmentId implements Serializable {
    @Serial
    private static final long serialVersionUID = -454465034846645641L;
    private Long vehicleId;
    private Long equipmentId;

}
