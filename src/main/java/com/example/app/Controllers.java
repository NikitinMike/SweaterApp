package com.example.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {

  @Autowired
  Services service;

  @GetMapping("/hello")
  public String greeting(Model model,
      @RequestParam(name = "name", required = false, defaultValue = "World") String name) {
    model.addAttribute("name", name);
    return "greetings";
  }

  @GetMapping("/all")
  private List<Message> getall(Model model) {
    return service.getAll();
  }

  @GetMapping("/id/{id}")
  private Message get(Model model, @RequestParam Long id) {
    return service.get(id);
  }

}
