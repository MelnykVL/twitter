package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetDeleteUseCase;
import org.springframework.stereotype.Component;

@Component
public class TweetDeleteUseCaseFacade implements TweetDeleteUseCase {

  private final TweetService tweetService;
  private final CurrentUserProfileApiService currentUserProfileApiService;

  public TweetDeleteUseCaseFacade(TweetService tweetService,
      CurrentUserProfileApiService currentUserProfileApiService) {
    this.tweetService = tweetService;
    this.currentUserProfileApiService = currentUserProfileApiService;
  }

  @Override
  public void deleteTweet(long tweetId) {
    UserProfile actor = this.currentUserProfileApiService.currentUserProfile();
    UserProfile owner = this.tweetService.findTweetById(tweetId)
        .map(Tweet::getUserProfile)
        .orElseThrow(() -> {
          String errorMessage = String.format("Tweet with Id = %d does not exist.", tweetId);
          return new RuntimeException(errorMessage);
        });

    if (!actor.equals(owner)) {
      String errorMessage = String.format("You cannot edit a tweet with Id = %d. User %s is not owner of the tweet.",
          tweetId, actor.getNickname());
      throw new RuntimeException(errorMessage);
    }

    this.tweetService.deleteTweet(tweetId);
  }
}
