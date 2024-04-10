package dev.petproject.twitter.subscription.usecase.impl;

import dev.petproject.twitter.subscription.mapper.UnsubscribeRequestToSubscriptionMapper;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.service.SubscriptionService;
import dev.petproject.twitter.subscription.usecase.SubscriptionDeleteUseCase;
import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDeleteUseCaseFacade implements SubscriptionDeleteUseCase {

  private final UnsubscribeRequestToSubscriptionMapper unsubscribeRequestToSubscriptionMapper;
  private final SubscriptionService subscriptionService;

  public SubscriptionDeleteUseCaseFacade(UnsubscribeRequestToSubscriptionMapper unsubscribeRequestToSubscriptionMapper,
      SubscriptionService subscriptionService) {
    this.unsubscribeRequestToSubscriptionMapper = unsubscribeRequestToSubscriptionMapper;
    this.subscriptionService = subscriptionService;
  }

  @Override
  public void unsubscribe(UnsubscribeRequest unsubscribeRequest) {
    Subscription subscription = this.unsubscribeRequestToSubscriptionMapper.map(unsubscribeRequest);
    UserProfile follower = subscription.getFollower();
    UserProfile followed = subscription.getFollowed();

    if (follower.equals(followed)) {
      throw new RuntimeException("There is no sense to unsubscribe from yourself.");
    }
    if (!this.subscriptionService.existsSubscription(subscription)) {
      String errorMessage = String.format("You're not subscribed to %s.", followed.getNickname());
      throw new RuntimeException(errorMessage);
    }
    this.subscriptionService.deleteSubscription(subscription);
  }
}
