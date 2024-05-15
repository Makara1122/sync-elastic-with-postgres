package org.example.jwtday2.repo;

import org.example.jwtday2.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleReposity extends JpaRepository<Role,String> {
    Optional<Role> findByName(String name);
}
