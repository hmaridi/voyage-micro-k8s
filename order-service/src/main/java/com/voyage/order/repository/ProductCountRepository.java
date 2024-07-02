package com.voyage.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voyage.order.entity.Product;

@Repository
public interface ProductCountRepository extends JpaRepository<Product, Long> {
}
