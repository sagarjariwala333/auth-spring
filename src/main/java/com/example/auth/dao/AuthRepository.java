package com.example.auth.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auth.entity.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
	Optional<Auth> findByUserId(long userId);
}
