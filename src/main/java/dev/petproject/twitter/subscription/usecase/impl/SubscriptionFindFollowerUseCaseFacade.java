package dev.petproject.twitter.subscription.usecase.impl;

import dev.petproject.twitter.subscription.model.FollowerSubscription;
import dev.petproject.twitter.subscription.model.Subscription_;
import dev.petproject.twitter.subscription.service.SubscriptionService;
import dev.petproject.twitter.subscription.usecase.SubscriptionFindFollowerUseCase;
import dev.petproject.twitter.subscription.web.model.FollowerFindRequest;
import dev.petproject.twitter.subscription.web.model.FollowerPageResponse;
import dev.petproject.twitter.subscription.web.model.FollowerResponse;
import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SubscriptionFindFollowerUseCaseFacade implements SubscriptionFindFollowerUseCase {

  private final UserProfileApiService userProfileApiService;
  private final SubscriptionService subscriptionService;

  public SubscriptionFindFollowerUseCaseFacade(UserProfileApiService userProfileApiService,
      SubscriptionService subscriptionService) {
    this.userProfileApiService = userProfileApiService;
    this.subscriptionService = subscriptionService;
  }

  @Override
  public FollowerPageResponse findFollowers(FollowerFindRequest findRequest) {
    UserProfile author = userProfileApiService.currentUserProfile();

    Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(),
        Sort.by(Sort.Direction.DESC, Subscription_.CREATED_TIMESTAMP));
    Page<FollowerSubscription> subscriptions = subscriptionService.findAllFollowerSubscriptions(author, pageable);

    List<FollowerResponse> followers = subscriptions.stream()
        .map(s -> new FollowerResponse(s.getId(), s.getFollower()
            .getId(), s.getFollower()
            .getNickname(), s.getFollower()
            .getImageLink(), s.getCreatedTimestamp()))
        .toList();

    return new FollowerPageResponse(subscriptions.getTotalElements(), subscriptions.isFirst(), subscriptions.isLast(),
        followers);
  }
}
