package com.example.app;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Message, Long> {
  Message findMessagesById(Long id);
  List<Message> findAll();
}
