package com.openclassrooms.mddapi.Models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
  @ManyToOne
  @JoinColumn(name = "subject", nullable = false)
  private Subject subject;


}
