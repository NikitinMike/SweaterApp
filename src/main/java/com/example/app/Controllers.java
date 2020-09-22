package com.example.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controllers {

  @Autowired
  Services service;

  @GetMapping("/")
  private List<Sweater> start(Model model) {
    return service.getAll();
  }

  @GetMapping("/all")
  private List<Sweater> getall(Model model) {
    return service.getAll();
  }

  @GetMapping("/id/{id}")
  private Sweater get(Model model, @RequestParam Long id) {
    return service.get(id);
  }

}
