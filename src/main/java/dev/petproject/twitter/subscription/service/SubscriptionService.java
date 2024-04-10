package dev.petproject.twitter.subscription.service;

import dev.petproject.twitter.subscription.model.Subscription;

public interface SubscriptionService {

  void subscribe(Subscription subscription);

  void unsubscribe(Subscription subscription);

  boolean existsSubscription(Subscription subscription);
}
