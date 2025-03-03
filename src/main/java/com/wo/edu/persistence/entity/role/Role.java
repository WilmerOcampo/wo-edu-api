package com.wo.edu.persistence.entity.role;

import com.wo.edu.persistence.entity.Base;
import com.wo.edu.persistence.entity.role.enums.ERole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role extends Base {
    @Column(name = "role", unique = true, nullable = false, updatable = false)
    @NotEmpty(message = "Este campo es obligatorio")
    @Enumerated(EnumType.STRING)
    private ERole eRole;
    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions = new HashSet<>();
}
