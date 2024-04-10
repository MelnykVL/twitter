package dev.petproject.twitter.subscription.usecase;

import dev.petproject.twitter.subscription.web.model.SubscribeRequest;

public interface SubscriptionAddUseCase {

  void subscribe(SubscribeRequest subscribeRequest);
}
