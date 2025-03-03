package com.wo.edu.web.security.payload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"userId", "roles", "professions", "message", "jwtToken", "isAuthenticated"})
public record LoginResponse(Long userId, List<String> roles, List<String> professions, String message,
                            String jwtToken,
                            Boolean isAuthenticated) {
}
