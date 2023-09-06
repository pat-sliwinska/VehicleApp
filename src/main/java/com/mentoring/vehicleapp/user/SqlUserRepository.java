package com.mentoring.vehicleapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlUserRepository extends JpaRepository<User, Long>, UserRepository {
}
