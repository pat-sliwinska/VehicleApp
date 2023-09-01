package com.mentoring.vehicleapp.user;

import com.mentoring.vehicleapp.basic_entity.BasicEntity;
import com.mentoring.vehicleapp.vehicle.Vehicle;
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
public class User extends BasicEntity {

    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Vehicle> vehicles;

    public User(String name) {
        this.name = name;
    }
}
