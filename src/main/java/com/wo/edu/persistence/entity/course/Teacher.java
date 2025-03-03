package com.wo.edu.persistence.entity.course;

import com.wo.edu.persistence.entity.UserMaster;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@Getter
@Setter
public class Teacher extends UserMaster {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_professions",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private Set<Profession> professions = new HashSet<>();

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();
}
