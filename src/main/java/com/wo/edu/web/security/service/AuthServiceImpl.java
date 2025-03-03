package com.wo.edu.web.security.service;

import com.wo.edu.domain.service.IUserService;
import com.wo.edu.persistence.entity.UserMaster;
import com.wo.edu.persistence.entity.course.Profession;
import com.wo.edu.persistence.entity.course.Teacher;
import com.wo.edu.web.security.jwt.JwtUtils;
import com.wo.edu.web.security.payload.LoginRequest;
import com.wo.edu.web.security.payload.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final IUserService userService;

    @Override
    public LoginResponse login(LoginRequest userRequest) {
        String username = userRequest.username();
        String password = userRequest.password();

        UserMaster userMaster = this.getUserMaster(username);

        Long userId = userMaster.getId();
        List<String> roles = this.getRoles(userMaster);
        List<String> professions = new ArrayList<>();
        if (roles.contains("TEACHER")) {
            professions = this.getProfessions(userMaster);
        }

        Authentication authentication = this.authenticateUser(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtUtils.createToken(authentication);

        return new LoginResponse(userId, roles, professions, "User logged successfully", token, true);
    }

    private UserMaster getUserMaster(String username) {
        Optional<UserMaster> userMasterOptional = this.userService.findByUsernameOrEmail(username, username);
        return userMasterOptional.orElseThrow(() -> new BadCredentialsException("User not found for username: " + username));
    }

    private Authentication authenticateUser(String username, String password) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }

    private List<String> getProfessions(UserMaster userMaster) {
        if (userMaster instanceof Teacher teacher) {
            return teacher.getProfessions().stream()
                    .map(Profession::getName)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<String> getRoles(UserMaster userMaster) {
        return userMaster.getRoles().stream()
                .map(role -> role.getERole().name())
                .collect(Collectors.toList());
    }
}
