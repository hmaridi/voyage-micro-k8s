package com.voyage.order.feign;

import com.voyage.order.dto.ApiResponse;
import com.voyage.order.dto.product.Product;
import com.voyage.order.util.AppConstants;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@FeignClient(name = "CART-SERVICE", url = AppConstants.BASE_URL)
public interface CartService {

    @GetMapping("api/cart/{id}")
    ResponseEntity<List<Product>> getCartItems(@PathVariable long id);

    @DeleteMapping("api/cart/remove/user/{id}")
    ResponseEntity<ApiResponse> removeCartByUserId(@PathVariable long id);
}
