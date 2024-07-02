package com.voyage.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voyage.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}