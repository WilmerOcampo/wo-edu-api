package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto extends BaseDto {
    private String name;
    private String email;
    private String number;
    private String message;
}
