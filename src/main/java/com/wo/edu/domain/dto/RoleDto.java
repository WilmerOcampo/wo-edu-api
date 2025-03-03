package com.wo.edu.domain.dto;

import com.wo.edu.persistence.entity.role.enums.ERole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto extends IdDto {
    private ERole name;
    private Boolean active;
}
