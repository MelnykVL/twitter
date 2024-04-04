package dev.petproject.twitter.user.tweet.mapper.impl;

import dev.petproject.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.petproject.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {

  private final CurrentUserProfileApiService currentUserProfileApiService;

  public TweetAddRequestToTweetMapperImpl(CurrentUserProfileApiService currentUserProfileApiService) {
    this.currentUserProfileApiService = currentUserProfileApiService;
  }

  @Override
  public Tweet map(TweetAddRequest tweetAddRequest) {
    Tweet tweet = new Tweet();
    tweet.setMessage(tweetAddRequest.message());
    tweet.setUserProfile(this.currentUserProfileApiService.currentUserProfile());

    return tweet;
  }
}
