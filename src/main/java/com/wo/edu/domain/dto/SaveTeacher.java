package com.wo.edu.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SaveTeacher extends UserData {
    private Set<Long> roleIds = new HashSet<>();
    private Set<Long> professionIds = new HashSet<>();
}
