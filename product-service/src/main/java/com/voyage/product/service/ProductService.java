package com.voyage.product.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.voyage.product.dto.ProductRequest;

import java.util.List;

@Service
public interface ProductService {

    ResponseEntity<?> createProduct(List<MultipartFile> images, ProductRequest productRequest);

    ResponseEntity<?> updateProduct(long id, List<MultipartFile> images, ProductRequest productRequest);

    ResponseEntity<?> deleteProductImage(long id, long imageId);

    ResponseEntity<?> getProducts();

    ResponseEntity<?> getProduct(long id);

    ResponseEntity<?> deleteProduct(long id);

    ResponseEntity<?> getCartProducts(List<Long> productIds);
}
