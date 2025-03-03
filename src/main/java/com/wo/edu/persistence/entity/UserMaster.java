package com.wo.edu.persistence.entity;

import com.wo.edu.persistence.entity.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_master")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class UserMaster extends Base {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    @Email
    private String email;
    @Column(nullable = false)
    @NotBlank(message = "La contraseña no puede estar vacía")
    @NotNull(message = "La contraseña no puede estar nulo")
    @NotEmpty(message = "Password no puede estar vacía")
    @Size(min = 6, message = "Password debe tener al menos 6 caracteres")
    private String password;
    @Column(name = "image_uri")
    private String imageUri;
    private Boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
