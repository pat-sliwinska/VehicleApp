package com.mentoring.vehicleapp.module.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mentoring.vehicleapp.shared.common.common.model.BasicEntity;
import com.mentoring.vehicleapp.module.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BasicEntity {

    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private List<Vehicle> vehicles;

    public User(String name) {
        this.name = name;
    }
}
