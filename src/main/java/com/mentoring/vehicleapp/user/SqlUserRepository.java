package com.mentoring.vehicleapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlUserRepository extends JpaRepository<User, Long>, UserRepository {

    @Override
    @Query(nativeQuery = true, value = "SELECT * FROM APP_USER" +
            " WHERE exists (select * from VEHICLE WHERE VEHICLE.USER_ID = APP_USER.ID AND VEHICLE.TYPE = 'CAR')")
    List<User> findAllWithCarEquipment();

    //@Override
    //@Query("SELECT u FROM User u")
    @Query(nativeQuery = true, value = "SELECT * FROM APP_USER")
    List<User> x();
}
