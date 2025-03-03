package com.wo.edu.web.security.service;

import com.wo.edu.web.security.payload.LoginRequest;
import com.wo.edu.web.security.payload.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest userRequest);
}
