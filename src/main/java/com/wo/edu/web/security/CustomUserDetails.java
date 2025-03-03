package com.wo.edu.web.security;

import com.wo.edu.persistence.entity.UserMaster;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetails implements UserDetails {
    private final Collection<? extends GrantedAuthority> authorities;
    private final String password;
    private final String username;

    @Getter
    private final Long id;
    @Getter
    private final String firstname;
    @Getter
    private final String lastname;

    public CustomUserDetails(UserMaster userMaster) {
        this.authorities = authorities(userMaster);
        this.password = userMaster.getPassword();
        this.username = userMaster.getUsername();

        this.id = userMaster.getId();
        this.firstname = userMaster.getFirstName();
        this.lastname = userMaster.getLastName();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    private Collection<? extends GrantedAuthority> authorities(UserMaster userMaster) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        userMaster.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getERole().name()));
            role.getPermissions().forEach(permission ->
                    authorities.add(new SimpleGrantedAuthority(permission.getEPermission().name())));
        });
        return authorities;
    }
}
