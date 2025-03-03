package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto extends UserData {
    private Date createdAt;
    private Set<String> roles = new HashSet<>();
    private Set<String> professions = new HashSet<>();
}
