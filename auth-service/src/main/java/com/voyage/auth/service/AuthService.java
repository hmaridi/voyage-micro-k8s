package com.voyage.auth.service;

import com.voyage.auth.dto.ApiResponse;
import com.voyage.auth.dto.CreateAccountRequest;
import com.voyage.auth.dto.LoginRequest;
import com.voyage.auth.dto.UserResponse;
import com.voyage.auth.entity.Token;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    ResponseEntity<?> createAccount(CreateAccountRequest createAccountRequest);

    ResponseEntity<?> login(LoginRequest loginRequest);

    ResponseEntity<?> logout(HttpServletRequest request);

    ResponseEntity<ApiResponse> validateToken(Token token);

    ResponseEntity<UserResponse> getUser(Token token);
}
