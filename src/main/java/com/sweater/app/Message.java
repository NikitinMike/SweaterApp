package com.sweater.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String text;
  @Order
  private String tag;

  public Message(String text, String tag) {
    this.text=text;
    this.tag=tag;
  }
}
