package com.voyage.gateway.dto;

public record ApiResponse(int statusCode, boolean status, String message) {
}
