package com.sweater.data;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Message, Long> {
  Message getById(Long id);
  @Query("select t from #{#entityName} t order by -t.id")
  List<Message> findAll();
  List<Message> findByTagContaining(String tag);
  List<Message> findByTagContainingOrTextContaining(String tag,String text);
}
