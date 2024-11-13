package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.SubscriptionDto;
import com.openclassrooms.mddapi.Models.Subscription;
import com.openclassrooms.mddapi.Services.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

  @PostMapping("/save")
  public ResponseEntity<SubscriptionDto> createSubscription(@RequestBody SubscriptionDto subscription) {
    System.out.println("Received SubscriptionDto: " + subscription);
    try {
      SubscriptionDto savedSubscription = this.subscriptionService.saveSubscription(subscription);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedSubscription);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.subscriptionService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<SubscriptionDto> findById(@PathVariable long id) {
        return this.subscriptionService.findById(id);
    }

    @GetMapping()
    public List<SubscriptionDto> getAll() {
        return this.subscriptionService.getAll();
    }

  @GetMapping("/subscribed/{userId}")
  public ResponseEntity<List<SubscriptionDto>> getUserSubscriptions(@PathVariable Long userId) {
    List<SubscriptionDto> subscriptions = subscriptionService.getListByUserId(userId);
    return ResponseEntity.ok(subscriptions);
  }
}
