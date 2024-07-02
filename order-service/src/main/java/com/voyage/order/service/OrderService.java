package com.voyage.order.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.voyage.order.dto.ShippingDetailsRequest;

@Service
public interface OrderService {

    ResponseEntity<?> createOrder(HttpServletRequest request, ShippingDetailsRequest shippingDetailsRequest);

    ResponseEntity<?> getOrders(HttpServletRequest request);

    ResponseEntity<?> getOrder(HttpServletRequest request, long id);

    ResponseEntity<?> deleteOrder(HttpServletRequest request, long id);
}
