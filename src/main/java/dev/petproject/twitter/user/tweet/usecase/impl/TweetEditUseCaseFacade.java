package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.mapper.TweetEditRequestToTweetMapper;
import dev.petproject.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetEditUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetEditRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetEditUseCaseFacade implements TweetEditUseCase {

  private final TweetService tweetService;
  private final TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper;
  private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
  private final UserProfileApiService userProfileApiService;

  public TweetEditUseCaseFacade(TweetService tweetService, TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper,
      TweetToTweetResponseMapper tweetToTweetResponseMapper, UserProfileApiService userProfileApiService) {
    this.tweetService = tweetService;
    this.tweetEditRequestToTweetMapper = tweetEditRequestToTweetMapper;
    this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
    this.userProfileApiService = userProfileApiService;
  }

  @Override
  public TweetResponse editTweet(TweetEditRequest tweetEditRequest) {
    UserProfile actor = this.userProfileApiService.currentUserProfile();
    UserProfile owner = this.tweetService.findTweetById(tweetEditRequest.id())
        .map(Tweet::getUserProfile)
        .orElseThrow(() -> {
          String errorMessage = String.format("Tweet with Id = %d does not exist.", tweetEditRequest.id());
          return new TwitterException(errorMessage);
        });

    if (!actor.equals(owner)) {
      String errorMessage = String.format("You cannot edit a tweet with Id = %d. User %s is not owner of the tweet.",
          tweetEditRequest.id(), actor.getNickname());
      throw new TwitterException(errorMessage);
    }

    Tweet tweet = this.tweetEditRequestToTweetMapper.map(tweetEditRequest);
    this.tweetService.updateTweet(tweet);

    return this.tweetToTweetResponseMapper.map(tweet);
  }
}
