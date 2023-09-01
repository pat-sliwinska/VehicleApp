package com.mentoring.vehicleapp.basic_entity;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class BasicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "updated_on")
    private Date updatedOn;
}
