package dev.petproject.twitter.user.tweet.mapper.impl;

import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import org.springframework.stereotype.Component;

@Component
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {

  private final UserProfileApiService userProfileApiService;

  public TweetAddRequestToTweetMapperImpl(UserProfileApiService userProfileApiService) {
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
