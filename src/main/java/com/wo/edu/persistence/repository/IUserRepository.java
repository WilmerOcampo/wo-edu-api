package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
