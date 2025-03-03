package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessionDto extends BaseDto {
    private String name;
    private Boolean active;
}
