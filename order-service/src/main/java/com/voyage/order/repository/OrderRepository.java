package com.voyage.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voyage.order.entity.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserIdOrderByIdDesc(long userId);

    Optional<Order> findByIdAndUserId(long id, long userId);

    void deleteByIdAndUserId(long id, long userId);
}
