package com.voyage.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voyage.auth.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
}
