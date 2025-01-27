package com.voyage.cart.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.voyage.cart.entity.Cart;

@Service
public interface CartService {

    ResponseEntity<?> addProduct(HttpServletRequest request, Cart cart);

    ResponseEntity<?> increaseItem(HttpServletRequest request, long productId);

    ResponseEntity<?> decreaseItem(HttpServletRequest request, long productId);

    ResponseEntity<?> removeItem(HttpServletRequest request, long productId);

    ResponseEntity<?> deleteCart(HttpServletRequest request);

    ResponseEntity<?> getCartItems(HttpServletRequest request);

    ResponseEntity<?> getCartItemsById(long userId);

    ResponseEntity<?> deleteCartById(long id);
}
