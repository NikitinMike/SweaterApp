package com.example.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

  @Autowired
  private Repository repository;

  public List<Sweater> getAll(){
    return repository.findAll();
  }
  public Sweater get(Long id){
    return repository.findSweatersById(id);
  }

}
