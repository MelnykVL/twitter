package dev.petproject.twitter.user.tweet.service;

import dev.petproject.twitter.user.tweet.model.Tweet;

import java.util.Optional;

public interface TweetService {

    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Optional<Tweet> findTweetById(long tweetId);
}
