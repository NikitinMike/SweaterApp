package com.example.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Services {

  @Autowired
  private MessagesRepository messages;

  @Autowired
  private UsersRepository users;

  public User getUser(String username){
    return users.findByUsername(username);
  }
  public void saveUser(User user){
    users.save(user);
  }

  public List<Message> getByTag(String tag){
    return messages.findByTagContaining(tag);
  }
  public List<Message> getAll(){
    return messages.findAll();
  }
  public Message get(Long id){
    return messages.getById(id);
  }

  public void newMessage(String text, String tag) {
    messages.save(new Message(text,tag));
  }
}
