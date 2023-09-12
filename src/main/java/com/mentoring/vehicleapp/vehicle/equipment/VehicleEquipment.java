package com.mentoring.vehicleapp.vehicle.equipment;

import com.mentoring.vehicleapp.common.BasicEntity;
import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "vehicle_equipment")
@Getter
@Setter
public class VehicleEquipment {

    @EmbeddedId
    private VehicleEquipmentId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id")
    @MapsId("vehicleId")
    private Vehicle vehicle;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    @MapsId("equipmentId")
    private Equipment equipment;
}
