package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.role.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPermissionRepository extends JpaRepository<Permission, Long> {
    List<Permission> findPermissionsByActiveTrue();
}
