package dev.petproject.twitter.user.tweet.service;

import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface TweetService {

  Tweet createTweet(Tweet tweet);

  Tweet updateTweet(Tweet tweet);

  Optional<Tweet> findTweetById(long tweetId);

  void deleteTweet(long tweetId);

  List<Tweet> findAllTweets(UserProfile owner, Pageable pageable);
}
