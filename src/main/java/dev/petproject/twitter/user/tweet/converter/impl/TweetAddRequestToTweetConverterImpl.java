package dev.petproject.twitter.user.tweet.converter.impl;

import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.tweet.converter.TweetAddRequestToTweetConverter;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetAddRequestToTweetConverterImpl implements TweetAddRequestToTweetConverter {

  private final UserProfileApiService userProfileApiService;

  public TweetAddRequestToTweetConverterImpl(UserProfileApiService userProfileApiService) {
    this.userProfileApiService = userProfileApiService;
  }

  @Override
  public Tweet convert(TweetAddRequest tweetAddRequest) {
    Tweet tweet = new Tweet();
    tweet.setMessage(tweetAddRequest.message());
    tweet.setUserProfile(this.userProfileApiService.currentUserProfile());

    return tweet;
  }
}
