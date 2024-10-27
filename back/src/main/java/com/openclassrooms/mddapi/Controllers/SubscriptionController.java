package com.openclassrooms.mddapi.Controllers;

import com.openclassrooms.mddapi.Dto.SubscriptionDto;
import com.openclassrooms.mddapi.Models.Subscription;
import com.openclassrooms.mddapi.Services.SubscriptionService;
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
    public SubscriptionDto createSubscription(@RequestBody SubscriptionDto subscription) {
        return this.subscriptionService.saveSubscription(subscription);
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
}
