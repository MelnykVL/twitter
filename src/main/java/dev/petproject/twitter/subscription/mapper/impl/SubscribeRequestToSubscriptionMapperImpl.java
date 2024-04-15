package dev.petproject.twitter.subscription.mapper.impl;

import dev.petproject.twitter.subscription.mapper.SubscribeRequestToSubscriptionMapper;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.SubscribeRequest;
import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class SubscribeRequestToSubscriptionMapperImpl implements SubscribeRequestToSubscriptionMapper {

  private final UserProfileApiService userProfileApiService;

  public SubscribeRequestToSubscriptionMapperImpl(UserProfileApiService userProfileApiService) {
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
