package dev.petproject.twitter.subscription.usecase.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.subscription.converter.SubscribeRequestToSubscriptionConverter;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.service.SubscriptionService;
import dev.petproject.twitter.subscription.usecase.SubscriptionAddUseCase;
import dev.petproject.twitter.subscription.web.model.SubscribeRequest;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionAddUseCaseFacade implements SubscriptionAddUseCase {

  private final SubscribeRequestToSubscriptionConverter subscribeRequestToSubscriptionConverter;
  private final SubscriptionService subscriptionService;

  public SubscriptionAddUseCaseFacade(SubscribeRequestToSubscriptionConverter subscribeRequestToSubscriptionConverter,
      SubscriptionService subscriptionService) {
    this.subscribeRequestToSubscriptionConverter = subscribeRequestToSubscriptionConverter;
    this.subscriptionService = subscriptionService;
  }

  @Override
  public void subscribe(SubscribeRequest subscribeRequest) {
    Subscription subscription = this.subscribeRequestToSubscriptionConverter.convert(subscribeRequest);
    UserProfile follower = subscription.getFollower();
    UserProfile followed = subscription.getFollowed();

    if (follower.equals(followed)) {
      throw new TwitterException("You cannot subscribe to yourself!");
    }
    if (this.subscriptionService.existsSubscription(subscription)) {
      String errorMessage = String.format("You're already subscribed to %s.", followed.getNickname());
      throw new TwitterException(errorMessage);
    }
    this.subscriptionService.createSubscription(subscription);
  }
}
