package com.wo.edu.web.security;

import com.wo.edu.web.security.jwt.JwtTokenValidator;
import com.wo.edu.web.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtUtils jwtUtils;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    // Endpoints públicos
                    http.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll();
                    http.requestMatchers("/api/home/**").permitAll();
                    http.requestMatchers("/api/auth/**").permitAll();
                    //http.requestMatchers("/api/auth/teacher/**").permitAll();
                    //http.requestMatchers("/api/auth/**").permitAll();

                    // Endpoints privados
                    http.requestMatchers(HttpMethod.GET, "/api/user/", "/api/course/user/").hasRole("TEACHER");
                    http.requestMatchers(HttpMethod.POST, "/api/course/save", "/api/topic/save").hasRole("TEACHER");
                    http.requestMatchers(HttpMethod.POST, "/api/user/**", "/api/permission/**", "/api/role/**", "/api/admin/**").hasRole("ADMIN");
                    //http.requestMatchers(HttpMethod.GET, "/api/admin/**").hasRole("ADMIN");
                    http.requestMatchers(HttpMethod.GET, "/api/user/**", "/api/permission/**", "/api/role/**").hasAnyAuthority("GET");

                    // Configurar el resto de endpoints - No especificados
                    http.anyRequest().denyAll(); // Rechaza aquello que no se especifica
                    //http.anyRequest().authenticated(); // Aunque no esté especificado deja pasar con las credenciales correctas
                })
                // Implementando validación de JWT Token
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
