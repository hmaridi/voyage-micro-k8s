package com.voyage.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.voyage.product.entity.Image;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductWrapper {
    private long id;
    private String title;
    private String description;
    private double price;
    private int discount;
    private List<Image> images;
    private boolean isAvailable;
    private int inStock;
    private String createdAt;
    private String updatedAt;
}
