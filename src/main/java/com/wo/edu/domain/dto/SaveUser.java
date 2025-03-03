package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SaveUser extends UserData {
    private Set<Long> roleIds = new HashSet<>();
}
