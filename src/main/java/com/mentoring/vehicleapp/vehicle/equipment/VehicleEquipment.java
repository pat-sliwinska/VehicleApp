package com.mentoring.vehicleapp.vehicle.equipment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "vehicle_equipment")
@Getter
@Setter
public class VehicleEquipment implements Serializable {

    @Serial
    private static final long serialVersionUID = -4544335034846645641L;

    @EmbeddedId
    private VehicleEquipmentId id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @MapsId("vehicleId")
    @JsonBackReference
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    @MapsId("equipmentId")
    @JsonBackReference
    private Equipment equipment;
}
