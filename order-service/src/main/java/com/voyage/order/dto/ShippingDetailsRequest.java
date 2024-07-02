package com.voyage.order.dto;

import com.voyage.order.dto.kafka.PayType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShippingDetailsRequest {
    private String name;
    private String phone;
    private String email;
    private String address;
    private PayType payType;
}
