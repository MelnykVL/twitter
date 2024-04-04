package dev.petproject.twitter.user.tweet.usecase;

import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;

public interface TweetAddUseCase {

  TweetResponse addTweet(TweetAddRequest tweetAddRequest);
}
