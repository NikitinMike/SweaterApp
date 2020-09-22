package com.example.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

  @Autowired
  private Repository repository;

  public List<Message> getByTag(String tag){
    return repository.findByTagContaining(tag);
  }
  public List<Message> getAll(){
    return repository.findAll();
  }
  public Message get(Long id){
    return repository.getById(id);
  }

  public void newMessage(String text, String tag) {
    repository.save(new Message(text,tag));
  }
}
