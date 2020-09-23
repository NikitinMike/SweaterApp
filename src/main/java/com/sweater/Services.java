package com.sweater;

import com.sweater.data.Message;
import com.sweater.data.MessagesRepository;
import com.sweater.data.User;
import com.sweater.data.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Services implements UserDetailsService {

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

  public List<Message> getMessagesByFilter(String text) {
    return messages.findByTagContainingOrTextContaining(text,text);
  }

  public List<Message> getAllMessages() {
    return messages.findAll();
  }

  public Message getMessage(Long id) {
    return messages.getById(id);
  }

  public Message newMessage(String text, String tag, User author) {
    return messages.save(new Message(text, tag, author));
  }

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return users.findByUsername(s);
  }
}
