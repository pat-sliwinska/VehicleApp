package com.mentoring.vehicleapp.equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository {

    Equipment save(Equipment equipment);

    List<Equipment> findAll();

    Optional<Equipment> findById(Long id);

    void deleteById(Long id);
}
