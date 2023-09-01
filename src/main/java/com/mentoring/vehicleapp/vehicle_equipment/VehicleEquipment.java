package com.mentoring.vehicleapp.vehicle_equipment;

import com.mentoring.vehicleapp.basic_entity.BasicEntity;
import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.vehicle.Vehicle;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class VehicleEquipment extends BasicEntity {

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
