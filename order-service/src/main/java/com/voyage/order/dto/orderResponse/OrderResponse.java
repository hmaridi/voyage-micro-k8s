package com.voyage.order.dto.orderResponse;

import com.voyage.order.dto.product.Product;
import com.voyage.order.entity.DeliveryStatus;
import com.voyage.order.entity.PaymentStatus;
import com.voyage.order.entity.ShippingDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private long id;
    private double totalPrice;
    private int discount;
    private double grandTotal;
    private List<Product> products;
    private DeliveryStatus deliveryStatus;
    private ShippingDetails shippingDetails;
    private PaymentStatus paymentStatus;
    private Date createdAt;
    private Date updatedAt;
}
