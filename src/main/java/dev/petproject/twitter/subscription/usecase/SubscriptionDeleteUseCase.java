package dev.petproject.twitter.subscription.usecase;

import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;

public interface SubscriptionDeleteUseCase {

  void unsubscribe(UnsubscribeRequest unsubscribeRequest);
}
