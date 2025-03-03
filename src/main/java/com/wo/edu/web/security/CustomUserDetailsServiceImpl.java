package com.wo.edu.web.security;

import com.wo.edu.domain.service.IUserService;
import com.wo.edu.persistence.entity.UserMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMaster userMaster = userService.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        return new CustomUserDetails(userMaster);
    }
}
