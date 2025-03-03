package com.wo.edu.persistence.entity.course;

import com.wo.edu.persistence.entity.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends Base {
    @Column(nullable = false)
    private String name;
    Boolean active;

    @ManyToMany(mappedBy = "categories")
    private Set<Course> courses = new HashSet<>();
}
