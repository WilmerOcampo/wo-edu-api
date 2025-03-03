package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseDto extends IdDto {
    private Date createdAt;
}
