package com.openclassrooms.mddapi.Services;

import com.openclassrooms.mddapi.Dto.SubscriptionDto;
import com.openclassrooms.mddapi.Models.Subscription;
import com.openclassrooms.mddapi.Repositories.SubscriptionRepository;
import com.openclassrooms.mddapi.Models.User;
import com.openclassrooms.mddapi.Models.Subject;
import com.openclassrooms.mddapi.Repositories.UserRepository;
import com.openclassrooms.mddapi.Repositories.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

  @Autowired
  private SubscriptionRepository subscriptionRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private ModelMapper modelMapper;

  // Méthode pour convertir un Subscription en SubscriptionDto
  private SubscriptionDto convertToDto(Subscription subscription) {
    return modelMapper.map(subscription, SubscriptionDto.class);
  }

  // Méthode pour convertir un SubscriptionDto en Subscription
  private Subscription convertToEntity(SubscriptionDto subscriptionDto) {
    Subscription subscription = modelMapper.map(subscriptionDto, Subscription.class);

    // Vérifiez que les objets User et Subject sont définis correctement
    if (subscriptionDto.getUser() != null && subscriptionDto.getUser().getId() != null) {
      User user = userRepository.findById(subscriptionDto.getUser().getId()).orElse(null);
      subscription.setUser(user);
    }

    if (subscriptionDto.getSubject() != null && subscriptionDto.getSubject().getId() != null) {
      Subject subject = subjectRepository.findById(subscriptionDto.getSubject().getId()).orElse(null);
      subscription.setSubject(subject);
    }

    return subscription;
  }

  public SubscriptionDto saveSubscription(SubscriptionDto subscriptionDto) {
    Subscription subscription = convertToEntity(subscriptionDto);
    Subscription savedSubscription = this.subscriptionRepository.save(subscription);
    return convertToDto(savedSubscription);
  }

  public Optional<SubscriptionDto> findById(long id) {
    Optional<Subscription> subscription = this.subscriptionRepository.findById(id);
    return subscription.map(this::convertToDto);
  }

  public void deleteById(long id) {
    this.subscriptionRepository.deleteById(id);
  }

  public List<SubscriptionDto> getAll() {
    List<Subscription> subscriptions = this.subscriptionRepository.findAll();
    return subscriptions.stream()
      .map(this::convertToDto)
      .collect(Collectors.toList());
  }

  public List<SubscriptionDto> getListByUserId(Long id) {
    List<Subscription> subscriptions = this.subscriptionRepository.findSubscriptionsByUserId(id);
    return subscriptions.stream()
      .map(this::convertToDto)
      .collect(Collectors.toList());
  }
}
