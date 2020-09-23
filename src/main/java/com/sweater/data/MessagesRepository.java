package com.sweater.data;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Message, Long> {
  Message getById(Long id);
  List<Message> findAll();
  List<Message> findByTagContaining(String tag);
  List<Message> findByTagContainingOrTextContaining(String tag,String text);
}
