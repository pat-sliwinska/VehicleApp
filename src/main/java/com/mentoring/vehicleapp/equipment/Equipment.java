package com.mentoring.vehicleapp.equipment;

import com.mentoring.vehicleapp.common.BasicEntity;
import com.mentoring.vehicleapp.vehicle.equipment.VehicleEquipment;
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
    private List<VehicleEquipment> vehicleEquipment;
    private String name;

    public Equipment(String name) {
        this.name = name;
    }
}
