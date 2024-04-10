package dev.petproject.twitter.subscription.service;

import dev.petproject.twitter.subscription.model.Subscription;

public interface SubscriptionService {

  void createSubscription(Subscription subscription);

  void deleteSubscription(Subscription subscription);

  boolean existsSubscription(Subscription subscription);
}
