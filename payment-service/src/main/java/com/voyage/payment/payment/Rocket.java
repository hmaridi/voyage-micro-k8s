package com.voyage.payment.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voyage.payment.dto.OrderEvent;
import com.voyage.payment.dto.PaymentStatus;

@Service
public class Rocket implements PaymentMethod {

    @Autowired
    private PaymentService paymentService;

    @Override
    public void makePayment(OrderEvent orderEvent) {
        paymentService.makePayment(orderEvent, PaymentStatus.FAILED, "Payment failed, try again later");
    }
}
