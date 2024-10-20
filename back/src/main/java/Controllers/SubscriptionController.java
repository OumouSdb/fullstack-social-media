package Controllers;

import Models.Subscription;
import Services.SubscriptionService;
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
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return this.subscriptionService.saveSubscription(subscription);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.subscriptionService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Subscription> findById(@PathVariable long id) {
        return this.subscriptionService.findById(id);
    }

    @GetMapping()
    public List<Subscription> getAll() {
        return this.subscriptionService.getAll();
    }
}
