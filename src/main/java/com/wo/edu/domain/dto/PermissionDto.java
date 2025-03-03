package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PermissionDto extends IdDto {
    private String name;
    private Boolean active;
}
