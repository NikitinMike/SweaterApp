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

  public User getUserByName(String username) {
    return users.findByUsername(username);
  }

  public void saveUser(User user) {
    users.save(user);
  }

  public List<Message> getMessagesByTag(String tag) {
    return messages.findByTagContaining(tag);
  }

  public List<Message> getAllMessages() {
    return messages.findAll();
  }

  public Message getMessage(Long id) {
    return messages.getById(id);
  }

  public Message newMessage(String text, String tag) {
    return messages.save(new Message(text, tag));
  }
}
