package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.user.tweet.converter.TweetAddRequestToTweetConverter;
import dev.petproject.twitter.user.tweet.converter.TweetToTweetResponseConverter;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetAddUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetAddUseCaseFacade implements TweetAddUseCase {

  private final TweetAddRequestToTweetConverter tweetAddRequestToTweetConverter;
  private final TweetToTweetResponseConverter tweetToTweetResponseConverter;
  private final TweetService tweetService;

  public TweetAddUseCaseFacade(TweetAddRequestToTweetConverter tweetAddRequestToTweetConverter,
      TweetToTweetResponseConverter tweetToTweetResponseConverter, TweetService tweetService) {
    this.tweetAddRequestToTweetConverter = tweetAddRequestToTweetConverter;
    this.tweetToTweetResponseConverter = tweetToTweetResponseConverter;
    this.tweetService = tweetService;
  }

  @Override
  public TweetResponse addTweet(TweetAddRequest tweetAddRequest) {
    Tweet tweet = this.tweetAddRequestToTweetConverter.convert(tweetAddRequest);
    tweetService.createTweet(tweet);
    return this.tweetToTweetResponseConverter.convert(tweet);
  }
}
