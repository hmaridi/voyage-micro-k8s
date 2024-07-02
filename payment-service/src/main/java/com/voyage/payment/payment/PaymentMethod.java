package com.voyage.payment.payment;

import org.springframework.stereotype.Service;

import com.voyage.payment.dto.OrderEvent;

@Service
public interface PaymentMethod {
    void makePayment(OrderEvent orderEvent);
}
