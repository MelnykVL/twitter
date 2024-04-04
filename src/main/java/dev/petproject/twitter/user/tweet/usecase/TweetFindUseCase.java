package dev.petproject.twitter.user.tweet.usecase;

import dev.petproject.twitter.user.tweet.web.model.TweetResponse;

import java.util.List;

public interface TweetFindUseCase {
    List<TweetResponse> findTweets();
}
