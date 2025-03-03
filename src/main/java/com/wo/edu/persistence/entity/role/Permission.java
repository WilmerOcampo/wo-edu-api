package com.wo.edu.persistence.entity.role;

import com.wo.edu.persistence.entity.Base;
import com.wo.edu.persistence.entity.role.enums.EPermission;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "permissions")
@Setter
@Getter
public class Permission extends Base {
    @Column(name = "permission", unique = true, nullable = false, updatable = false)
    @NotEmpty(message = "Este campo es obligatorio")
    @Enumerated(EnumType.STRING)
    private EPermission ePermission;
    private Boolean active;
}
