package com.voyage.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voyage.cart.entity.Cart;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findCartByUserId(long userId);

    Optional<Cart> findCartByUserIdAndProductId(long userId, long productId);

    void deleteCartByUserIdAndProductId(long userId, long productId);

    void deleteAllByUserId(long userId);
}
