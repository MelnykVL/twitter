package dev.petproject.twitter.subscription.service;

import dev.petproject.twitter.subscription.model.FollowerSubscription;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubscriptionService {

  void createSubscription(Subscription subscription);

  void deleteSubscription(Subscription subscription);

  boolean existsSubscription(Subscription subscription);

  Page<FollowerSubscription> findAllFollowerSubscriptions(UserProfile author, Pageable pageable);
}
