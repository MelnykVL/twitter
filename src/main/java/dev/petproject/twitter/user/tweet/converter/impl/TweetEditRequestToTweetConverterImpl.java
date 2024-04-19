package dev.petproject.twitter.user.tweet.converter.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.user.tweet.converter.TweetEditRequestToTweetConverter;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.web.model.TweetEditRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetEditRequestToTweetConverterImpl implements TweetEditRequestToTweetConverter {

  private final TweetService tweetService;

  public TweetEditRequestToTweetConverterImpl(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @Override
  public Tweet convert(TweetEditRequest tweetEditRequest) {
    Tweet currentTweet = this.tweetService.findTweetById(tweetEditRequest.id())
        .orElseThrow(() -> {
          String errorMessage = String.format("Tweet with Id = %d does not exist.", tweetEditRequest.id());
          return new TwitterException(errorMessage);
        });
    currentTweet.setMessage(tweetEditRequest.message());

    return currentTweet;
  }
}
