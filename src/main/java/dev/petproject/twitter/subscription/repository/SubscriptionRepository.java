package dev.petproject.twitter.subscription.repository;

import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

  boolean existsByFollowerAndFollowed(UserProfile follower, UserProfile followed);
}
