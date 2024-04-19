package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.common.exception.TwitterException;
import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.converter.TweetEditRequestToTweetConverter;
import dev.petproject.twitter.user.tweet.converter.TweetToTweetResponseConverter;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetEditUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetEditRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetEditUseCaseFacade implements TweetEditUseCase {

  private final TweetService tweetService;
  private final TweetEditRequestToTweetConverter tweetEditRequestToTweetConverter;
  private final TweetToTweetResponseConverter tweetToTweetResponseConverter;
  private final UserProfileApiService userProfileApiService;

  public TweetEditUseCaseFacade(TweetService tweetService,
      TweetEditRequestToTweetConverter tweetEditRequestToTweetConverter,
      TweetToTweetResponseConverter tweetToTweetResponseConverter, UserProfileApiService userProfileApiService) {
    this.tweetService = tweetService;
    this.tweetEditRequestToTweetConverter = tweetEditRequestToTweetConverter;
    this.tweetToTweetResponseConverter = tweetToTweetResponseConverter;
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

    Tweet tweet = this.tweetEditRequestToTweetConverter.convert(tweetEditRequest);
    this.tweetService.updateTweet(tweet);

    return this.tweetToTweetResponseConverter.convert(tweet);
  }
}
