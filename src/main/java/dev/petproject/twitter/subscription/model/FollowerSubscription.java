package dev.petproject.twitter.subscription.model;

import dev.petproject.twitter.user.profile.model.UserProfile;
import java.time.Instant;

public interface FollowerSubscription {

  long getId();

  UserProfile getFollower();

  Instant getCreatedTimestamp();
}
