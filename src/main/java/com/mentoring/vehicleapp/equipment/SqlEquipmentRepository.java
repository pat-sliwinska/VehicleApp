package com.mentoring.vehicleapp.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlEquipmentRepository extends JpaRepository<Equipment, Long>, EquipmentRepository{
}
