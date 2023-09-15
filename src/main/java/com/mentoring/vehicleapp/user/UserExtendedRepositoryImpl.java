package com.mentoring.vehicleapp.user;

import com.mentoring.vehicleapp.equipment.Equipment;
import com.mentoring.vehicleapp.vehicle.VehicleType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class UserExtendedRepositoryImpl implements UserExtendedRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserForVehicleTypeEquipmentDTO> findAllForVehicleType(String vehicleType) {

//        return entityManager.createQuery("""
//                SELECT u, eq
//                FROM User u
//                JOIN u.vehicles v
//                JOIN v.vehicleEquipment veq
//                JOIN veq.equipment eq
//                WHERE v.type = :type
//                """, UserForVehicleTypeEquipmentDTO.class)
//                .setParameter("type", EnumUtils.getEnum(VehicleType.class ,vehicleType))
//                .getResultList();

        List<Object[]> queryResults = entityManager.createQuery("""
                SELECT u, eq
                FROM User u
                JOIN u.vehicles v 
                JOIN v.vehicleEquipment veq
                JOIN veq.equipment eq
                WHERE v.type = :type
                """)
                .setParameter("type", EnumUtils.getEnum(VehicleType.class ,vehicleType))
                .getResultList();

        List<UserForVehicleTypeEquipmentDTO> dtoList = new ArrayList<>();
        queryResults.forEach(result -> {
            User userFromResult = (User)result[0];
            Equipment eqFromResult = (Equipment)result[1];
            if(dtoList.stream().anyMatch(dto -> dto.getId() == userFromResult.getId())) {
                UserForVehicleTypeEquipmentDTO existingDto = dtoList.stream().filter(dto -> dto.getId() == userFromResult.getId()).findFirst().get();
                existingDto.getEquipment().add(eqFromResult);
            } else {
                UserForVehicleTypeEquipmentDTO newDto = UserForVehicleTypeEquipmentDTO.builder()
                        .id(userFromResult.getId())
                        .name(userFromResult.getName())
                        .equipment(new HashSet<>())
                        .build();
                newDto.getEquipment().add(eqFromResult);
                dtoList.add(newDto);
            }
        });

        return dtoList;
    }

}
