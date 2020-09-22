package com.example.app;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Sweater, Long> {
  Sweater findSweatersById(Long id);
  List<Sweater> findAll();
}
