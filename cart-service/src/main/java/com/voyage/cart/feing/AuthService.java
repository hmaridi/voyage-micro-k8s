package com.voyage.cart.feing;

import com.voyage.cart.dto.ApiResponse;
import com.voyage.cart.dto.Token;
import com.voyage.cart.dto.UserResponse;
import com.voyage.cart.util.AppConstants;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(name = "AUTH-SERVICE", url = AppConstants.BASE_URL)
public interface AuthService {

    @PostMapping("api/auth/validate-token")
    ResponseEntity<ApiResponse> validateToken(@RequestBody Token token);

    @GetMapping("api/auth/user")
    ResponseEntity<UserResponse> getUser(@RequestBody Token token);
}
