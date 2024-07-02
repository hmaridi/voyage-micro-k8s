package com.voyage.order.dto.kafka;

import com.voyage.order.entity.PaymentStatusEnum;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentEvent {
    private long userId;
    private long orderId;
    private double amount;
    private String message;
    private PaymentStatusEnum paymentStatus;
    private PayType payType;
}
