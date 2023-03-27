package com.happypaws.happypaws.security.repository;

import com.happypaws.happypaws.security.model.Role;
import com.happypaws.happypaws.security.model.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RolesEnum name);
}
