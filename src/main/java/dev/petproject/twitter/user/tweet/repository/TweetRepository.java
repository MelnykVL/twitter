package dev.petproject.twitter.user.tweet.repository;

import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

  Page<Tweet> findAllByUserProfile(UserProfile owner, Pageable pageable);
}
