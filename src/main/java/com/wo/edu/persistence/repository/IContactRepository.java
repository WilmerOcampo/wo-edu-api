package com.wo.edu.persistence.repository;

import com.wo.edu.persistence.entity.user.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContactRepository extends JpaRepository<Contact, Long> {
}
