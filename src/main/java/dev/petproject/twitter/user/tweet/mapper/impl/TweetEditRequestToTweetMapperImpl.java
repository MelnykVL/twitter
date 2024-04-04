package dev.petproject.twitter.user.tweet.mapper.impl;

import dev.petproject.twitter.user.tweet.mapper.TweetEditRequestToTweetMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.web.model.TweetEditRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetEditRequestToTweetMapperImpl implements TweetEditRequestToTweetMapper {

  private final TweetService tweetService;

  public TweetEditRequestToTweetMapperImpl(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @Override
  public Tweet map(TweetEditRequest tweetEditRequest) {
    Tweet currentTweet = this.tweetService.findTweetById(tweetEditRequest.id())
        .orElseThrow(() -> {
          String errorMessage = String.format("Tweet with Id = %d does not exist.", tweetEditRequest.id());
          return new RuntimeException(errorMessage);
        });
    currentTweet.setMessage(tweetEditRequest.message());

    return currentTweet;
  }
}
