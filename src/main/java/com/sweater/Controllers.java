package com.sweater;

import com.sweater.data.Role;
import com.sweater.data.User;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {

  @Autowired
  Services service;

  @GetMapping("/registration")
  public String registration() {
    return "registration";
  }

  @PostMapping("/registration")
  public String addUser(User user, Model model) {
    if (service.getUserByName(user.getUsername()) != null) {
      model.addAttribute("message", "User exists");
      return "registration";
    }
    user.setActive(true);
    user.setRoles(Collections.singleton(Role.USER));
    service.saveUser(user);
    return "redirect:/login";
  }

  @GetMapping("/")
  public String start(Model model,@AuthenticationPrincipal User user)
  {
    model.addAttribute("name", (user!=null)?user.getUsername():"World");
    return "greetings";
  }

  @GetMapping("main")
  public String main(Model model,
      @RequestParam(required = false, defaultValue = "") String filter)
  {
    if (filter == null || filter.isBlank() || filter.isEmpty()) {
      model.addAttribute("messages", service.getAllMessages());
    } else {
      model.addAttribute("messages", service.getMessagesByFilter(filter));
    }
    model.addAttribute("filter", filter);
    return "main";
  }

  @PostMapping("main")
  public String addMessage(@AuthenticationPrincipal User user, Model model,
      @RequestParam(required = false, defaultValue = "") String filter,
      @RequestParam String text, @RequestParam String tag) {
    service.newMessage(text, tag, user);
    model.addAttribute("messages", service.getAllMessages());
    model.addAttribute("filter", filter);
    return "main";
  }

}
