package dev.petproject.twitter.user.tweet.usecase;

import dev.petproject.twitter.user.tweet.web.model.TweetEditRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;

public interface TweetEditUseCase {

    TweetResponse editTweet(TweetEditRequest tweetEditRequest);
}
