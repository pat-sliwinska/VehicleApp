package com.mentoring.vehicleapp.module.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlEquipmentRepository extends JpaRepository<Equipment, Long>, EquipmentRepository{
}
