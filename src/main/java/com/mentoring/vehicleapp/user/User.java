package com.mentoring.vehicleapp.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mentoring.vehicleapp.common.BasicEntity;
import com.mentoring.vehicleapp.vehicle.Vehicle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
public class User extends BasicEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -454465034846645641L;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Vehicle> vehicles;

    public User(String name) {
        this.name = name;
    }
}
