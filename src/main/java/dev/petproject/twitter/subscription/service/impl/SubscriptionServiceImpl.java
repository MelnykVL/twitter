package dev.petproject.twitter.subscription.service.impl;

import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.repository.SubscriptionRepository;
import dev.petproject.twitter.subscription.service.SubscriptionService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

  private final SubscriptionRepository subscriptionRepository;

  public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
    this.subscriptionRepository = subscriptionRepository;
  }

  @Override
  public void createSubscription(Subscription subscription) {
    this.subscriptionRepository.save(subscription);
  }

  @Override
  public void deleteSubscription(Subscription subscription) {
    this.subscriptionRepository.deleteById(subscription.getId());
  }

  @Override
  public boolean existsSubscription(Subscription subscription) {
    UserProfile follower = subscription.getFollower();
    UserProfile followed = subscription.getFollowed();
    return this.subscriptionRepository.existsByFollowerAndFollowed(follower, followed);
  }
}
