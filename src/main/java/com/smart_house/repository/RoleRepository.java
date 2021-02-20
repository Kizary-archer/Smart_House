package com.smart_house.repository;

import com.smart_house.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<UserRole, Integer> {

    Optional<UserRole> findByRole(String role);
}
