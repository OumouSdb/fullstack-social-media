package Services;

import Models.Subscription;
import Repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription saveSubscription(Subscription subscription) {
        return this.subscriptionRepository.save(subscription);
    }

    public Optional<Subscription> findById(long id) {
        return this.subscriptionRepository.findById(id);
    }

    public void deleteById(long id) {
        this.subscriptionRepository.deleteById(id);
    }

    public List<Subscription> getAll() {
        return this.subscriptionRepository.findAll();
    }
}
