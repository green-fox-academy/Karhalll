package com.greenfox.programmingfoxclub.repositary;

import com.greenfox.programmingfoxclub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
  User findFirstByUsername(String username);
}
