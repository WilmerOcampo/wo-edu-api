package com.wo.edu.persistence.entity.user;

import com.wo.edu.persistence.entity.UserMaster;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends UserMaster {
    @OneToMany(mappedBy = "user")
    private Set<Bookmark> bookmarks = new HashSet<>();
}
