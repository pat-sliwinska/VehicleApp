package com.mentoring.vehicleapp.vehicle;

import com.mentoring.vehicleapp.user.User;
import com.mentoring.vehicleapp.basic_entity.BasicEntity;
import com.mentoring.vehicleapp.vehicle_equipment.VehicleEquipment;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleEquipment> vehicleEquipment;
    private String brand;
    private String model;
    @Column(name = "number_of_seats")
    private int numberOfSeats;
    @Column(name = "production_year")
    private int productionYear;
    @Column(name = "top_speed")
    private int topSpeed;
    private VehicleType type;

    public Vehicle(String brand, String model, VehicleType type) {
        this.brand = brand;
        this.model = model;
        this.type = type;
    }


}
