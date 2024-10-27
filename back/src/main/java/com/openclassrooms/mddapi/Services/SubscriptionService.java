package com.openclassrooms.mddapi.Services;

import com.openclassrooms.mddapi.Dto.SubscriptionDto;
import com.openclassrooms.mddapi.Models.Subscription;
import com.openclassrooms.mddapi.Repositories.SubscriptionRepository;
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
  private ModelMapper modelMapper;

  // Méthode pour convertir un Subscription en SubscriptionDto
  private SubscriptionDto convertToDto(Subscription subscription) {
    return modelMapper.map(subscription, SubscriptionDto.class);
  }

  // Méthode pour convertir un SubscriptionDto en Subscription
  private Subscription convertToEntity(SubscriptionDto subscriptionDto) {
    return modelMapper.map(subscriptionDto, Subscription.class);
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
}
