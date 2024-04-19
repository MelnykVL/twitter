package dev.petproject.twitter.subscription.converter.impl;

import dev.petproject.twitter.subscription.converter.SubscribeRequestToSubscriptionConverter;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.SubscribeRequest;
import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class SubscribeRequestToSubscriptionConverterImpl implements SubscribeRequestToSubscriptionConverter {

  private final UserProfileApiService userProfileApiService;

  public SubscribeRequestToSubscriptionConverterImpl(UserProfileApiService userProfileApiService) {
    this.userProfileApiService = userProfileApiService;
  }

  @Override
  public Subscription convert(SubscribeRequest subscribeRequest) {
    UserProfile follower = this.userProfileApiService.currentUserProfile();
    UserProfile followed = this.userProfileApiService.findUserProfileById(subscribeRequest.followedId());
    Subscription subscription = new Subscription();
    subscription.setFollower(follower);
    subscription.setFollowed(followed);

    return subscription;
  }
}
