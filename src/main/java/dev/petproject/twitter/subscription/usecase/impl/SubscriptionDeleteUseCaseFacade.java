package dev.petproject.twitter.subscription.usecase.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.subscription.converter.UnsubscribeRequestToSubscriptionConverter;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.service.SubscriptionService;
import dev.petproject.twitter.subscription.usecase.SubscriptionDeleteUseCase;
import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionDeleteUseCaseFacade implements SubscriptionDeleteUseCase {

  private final UnsubscribeRequestToSubscriptionConverter unsubscribeRequestToSubscriptionConverter;
  private final SubscriptionService subscriptionService;

  public SubscriptionDeleteUseCaseFacade(
      UnsubscribeRequestToSubscriptionConverter unsubscribeRequestToSubscriptionConverter,
      SubscriptionService subscriptionService) {
    this.unsubscribeRequestToSubscriptionConverter = unsubscribeRequestToSubscriptionConverter;
    this.subscriptionService = subscriptionService;
  }

  @Override
  public void unsubscribe(UnsubscribeRequest unsubscribeRequest) {
    Subscription subscription = this.unsubscribeRequestToSubscriptionConverter.convert(unsubscribeRequest);
    UserProfile follower = subscription.getFollower();
    UserProfile followed = subscription.getFollowed();

    if (follower.equals(followed)) {
      throw new TwitterException("There is no sense to unsubscribe from yourself.");
    }
    if (!this.subscriptionService.existsSubscription(subscription)) {
      String errorMessage = String.format("You're not subscribed to %s.", followed.getNickname());
      throw new TwitterException(errorMessage);
    }
    this.subscriptionService.deleteSubscription(subscription);
  }
}
