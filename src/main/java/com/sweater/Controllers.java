package com.sweater;

import com.sweater.data.Message;
import com.sweater.data.Role;
import com.sweater.data.User;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
  public String start(Model model) {
    model.addAttribute("name", "user");
    return "greetings";
  }

  @GetMapping("/hello")
  public String greeting(Model model,
      @RequestParam(name = "name", required = false, defaultValue = "World") String name) {
    model.addAttribute("name", name);
    return "greetings";
  }

  @GetMapping("main")
  public String main(Model model, @RequestParam(required = false, defaultValue = "") String filter) {
    model.addAttribute("some", "Сообщения");
    if (filter == null || filter.isBlank() || filter.isEmpty()) {
      model.addAttribute("messages", service.getAllMessages());
    } else {
      model.addAttribute("messages", service.getMessagesByFilter(filter));
    }
    model.addAttribute("filter", filter);
    return "main";
  }

  @PostMapping("main")
  public String add(@AuthenticationPrincipal User user, Model model,
      @RequestParam(required = false, defaultValue = "") String filter,
      @RequestParam String text, @RequestParam String tag) {
    service.newMessage(text, tag, user);
    model.addAttribute("some", "Сообщения");
    model.addAttribute("messages", service.getAllMessages());
    model.addAttribute("filter", filter);
    return "main";
  }

  @GetMapping("all")
  @ResponseBody
  private List<Message> getall(Model model) {
    return service.getAllMessages();
  }

  @GetMapping("id/{id}")
  @ResponseBody
  private Message get(Model model, @RequestParam Long id) {
    return service.getMessage(id);
  }

}
