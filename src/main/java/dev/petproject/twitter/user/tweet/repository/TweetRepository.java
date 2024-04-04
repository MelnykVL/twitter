package dev.petproject.twitter.user.tweet.repository;

import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

  List<Tweet> findAllByUserProfile(UserProfile owner);
}
