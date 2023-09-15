package com.mentoring.vehicleapp.module.equipment;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mentoring.vehicleapp.shared.common.model.BasicEntity;
import com.mentoring.vehicleapp.module.vehicle.equipment.VehicleEquipment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Equipment extends BasicEntity {

    @OneToMany(mappedBy = "equipment", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<VehicleEquipment> vehicleEquipment;
    private String name;

    public Equipment(String name) {
        this.name = name;
    }
}
