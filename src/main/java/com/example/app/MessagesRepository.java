package com.example.app;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Message, Long> {
  Message getById(Long id);
  List<Message> findAll();
  List<Message> findByTagContaining(String tag);
}
