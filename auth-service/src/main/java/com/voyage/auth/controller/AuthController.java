package com.voyage.auth.controller;

import com.voyage.auth.dto.ApiResponse;
import com.voyage.auth.dto.CreateAccountRequest;
import com.voyage.auth.dto.LoginRequest;
import com.voyage.auth.dto.UserResponse;
import com.voyage.auth.entity.Token;
import com.voyage.auth.service.AuthService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Value("${application.mode}")
    private String applicationMode;

    @PostMapping("/create")
    @CircuitBreaker(name = "createAccount", fallbackMethod = "fallback")
    public ResponseEntity<?> createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        return authService.createAccount(createAccountRequest);
    }

    @PostMapping("/login")
    @CircuitBreaker(name = "login", fallbackMethod = "fallback")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("/logout")
    @CircuitBreaker(name = "logout", fallbackMethod = "fallback")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        return authService.logout(request);
    }

    @PostMapping("/validate-token")
    @CircuitBreaker(name = "validateToken", fallbackMethod = "fallback")
    public ResponseEntity<?> validateToken(@RequestBody Token token) {
        return authService.validateToken(token);
    }

    @PostMapping("/user")
    @CircuitBreaker(name = "getUser", fallbackMethod = "fallback")
    public ResponseEntity<UserResponse> getUser(@RequestBody Token token) {
        return authService.getUser(token);
    }

    private ResponseEntity<?> fallback(Exception e) {
        return new ResponseEntity<>(new ApiResponse(
                false,
                applicationMode.equals("debug") ? e.getLocalizedMessage() : "Some of the services are not working, try in a while."
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
