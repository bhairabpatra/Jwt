package com.jwt.auth.Jwt.repository;

import com.jwt.auth.Jwt.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
