package com.mentoring.vehicleapp.vehicle;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mentoring.vehicleapp.user.User;
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
public class Vehicle extends BasicEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @OneToMany(mappedBy = "vehicle", orphanRemoval = true, fetch = FetchType.LAZY)
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
