package com.sweater.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {

  List<User> findAll();
  User findByUsername(String username);
}
