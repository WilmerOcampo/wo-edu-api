package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    List<Role> findRolesByActiveTrue();

    Set<Role> findByIdIn(Set<Long> ids);
}
