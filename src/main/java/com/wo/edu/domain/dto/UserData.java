package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UserData extends IdDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String imageUri;
    private Boolean active;
}
