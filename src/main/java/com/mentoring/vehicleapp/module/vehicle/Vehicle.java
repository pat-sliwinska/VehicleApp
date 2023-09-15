package com.mentoring.vehicleapp.module.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mentoring.vehicleapp.module.user.User;
import com.mentoring.vehicleapp.module.vehicle.equipment.VehicleEquipment;
import com.mentoring.vehicleapp.shared.common.common.model.BasicEntity;
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
public class Vehicle extends BasicEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "vehicle", orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<VehicleEquipment> vehicleEquipment;

    private String brand;
    private String model;
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @Column(name = "production_year")
    private int productionYear;
    @Column(name = "top_speed")
    private int topSpeed;
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    public Vehicle(String brand, String model, VehicleType type) {
        this.brand = brand;
        this.model = model;
        this.type = type;
    }


}
