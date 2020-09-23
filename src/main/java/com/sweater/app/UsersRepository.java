package com.sweater.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {

  User findByUsername(String username);
}
