package com.voyage.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voyage.inventory.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {}
