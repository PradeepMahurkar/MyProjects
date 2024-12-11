package com.example.institute.repo;

import com.example.institute.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity ,Long> {
    Optional<UserEntity> findByEmail(String email);
//    for Authenticate ID and Pass
//    Optional<UserEntity> findByUsername(String email);
}
