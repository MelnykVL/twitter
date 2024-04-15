package dev.petproject.twitter.subscription.mapper.impl;

import dev.petproject.twitter.subscription.mapper.UnsubscribeRequestToSubscriptionMapper;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;
import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UnsubscribeRequestToSubscriptionMapperImpl implements UnsubscribeRequestToSubscriptionMapper {

  private final UserProfileApiService userProfileApiService;

  public UnsubscribeRequestToSubscriptionMapperImpl(UserProfileApiService userProfileApiService) {
    this.userProfileApiService = userProfileApiService;
  }

  @Override
  public Subscription convert(UnsubscribeRequest unsubscribeRequest) {
    UserProfile follower = this.userProfileApiService.currentUserProfile();
    UserProfile followed = this.userProfileApiService.findUserProfileById(unsubscribeRequest.followedId());
    Subscription subscription = new Subscription();
    subscription.setFollower(follower);
    subscription.setFollowed(followed);

    return subscription;
  }
}
