package com.voyage.cart.feing;

import com.voyage.cart.dto.ApiResponse;
import com.voyage.cart.dto.InventoryResponse;
import com.voyage.cart.util.AppConstants;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "INVENTORY-SERVICE", url = AppConstants.BASE_URL)
public interface InventoryService {

    @GetMapping("/api/inventory/{id}")
    ResponseEntity<InventoryResponse> getProduct(@PathVariable long id);

    @GetMapping("/api/inventory/{id}")
    ResponseEntity<ApiResponse> getProductError(@PathVariable long id);
}
