package com.voyage.cart.aspect;

import com.voyage.cart.dto.ApiResponse;
import com.voyage.cart.dto.Token;
import com.voyage.cart.feing.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class TokenValidationAspect {

    @Autowired
    private AuthService authService;

    @Around("execution(public * com.voyage.cart.service.CartService.*(..))" +
            "&& !execution(public * com.voyage.cart.service.CartService.getCartItemsById(..))" +
            "&& !execution(public * com.voyage.cart.service.CartService.deleteCartById(..))")
    public Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        if (isTokenValid(request)) {
            return joinPoint.proceed();
        }
        else {
            return new ResponseEntity<>(new ApiResponse(false, "User is not authenticated"), HttpStatus.UNAUTHORIZED);
        }
    }

    private boolean isTokenValid(HttpServletRequest request) {
        String requestHeader = request.getHeader("Authorization");
        String token = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer") && requestHeader.length() > 8) token = requestHeader.substring(7);
        if (token == null) return false;
        try {
            return authService.validateToken(new Token(token)).getStatusCode().isSameCodeAs(HttpStatus.OK);
        } catch (Exception e) {
            return false;
        }
    }
}
