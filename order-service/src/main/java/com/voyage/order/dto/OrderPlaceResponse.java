package com.voyage.order.dto;

public record OrderPlaceResponse(boolean status, String message, long orderId) {
}
