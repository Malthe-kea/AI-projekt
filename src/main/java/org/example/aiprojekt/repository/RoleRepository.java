package org.example.aiprojekt.repository;


import org.example.aiprojekt.model.Role;
import org.example.aiprojekt.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}