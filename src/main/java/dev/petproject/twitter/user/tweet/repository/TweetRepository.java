package dev.petproject.twitter.user.tweet.repository;

import dev.petproject.twitter.user.tweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
