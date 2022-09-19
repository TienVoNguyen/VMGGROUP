package com.example.thuchanhbuoi10.repository;

import java.util.Optional;

import com.example.thuchanhbuoi10.models.ERole;
import com.example.thuchanhbuoi10.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
