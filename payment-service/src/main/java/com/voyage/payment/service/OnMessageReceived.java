package com.voyage.payment.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface OnMessageReceived {
    void onEvent(String event) throws JsonProcessingException;
}
