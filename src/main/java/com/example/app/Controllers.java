package com.example.app;

import java.util.List;
import java.util.Map;
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
  public String greeting(Map<String,Object> model,
      @RequestParam(name = "name", required = false, defaultValue = "World") String name) {
    model.put("name", name);
    return "greetings";
  }

  @GetMapping
  public String main(Map<String,Object> model) {
    model.put("some", "Hello, Lets code");
    return "main";
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
