package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.UserMaster;
import com.wo.edu.persistence.entity.role.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserMasterRepository extends JpaRepository<UserMaster, Long> {
    Optional<UserMaster> findByUsernameOrEmail(String username, String email);

    @Query("SELECT u FROM UserMaster u JOIN u.roles r WHERE r.eRole = :role")
    List<UserMaster> findByRoleName(ERole role);
}
