package com.wo.edu.persistence.entity.user;

import com.wo.edu.persistence.entity.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact extends Base {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private String number;
    @Column(nullable = false)
    private String message;
}
