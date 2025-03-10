package dev.petproject.twitter.subscription.repository;

import dev.petproject.twitter.subscription.model.FollowerSubscription;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

  boolean existsByFollowerAndFollowed(UserProfile follower, UserProfile followed);

  Optional<Subscription> findByFollowerAndFollowed(UserProfile follower, UserProfile followedo);

  Page<FollowerSubscription> findAllByFollowed(UserProfile author, Pageable pageable);
}
