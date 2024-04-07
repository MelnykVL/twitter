package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetFindUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetFindRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TweetFindUseCaseFacade implements TweetFindUseCase {

  private final TweetService tweetService;
  private final CurrentUserProfileApiService currentUserProfileApiService;
  private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

  public TweetFindUseCaseFacade(TweetService tweetService, CurrentUserProfileApiService currentUserProfileApiService,
      TweetToTweetResponseMapper tweetToTweetResponseMapper) {
    this.tweetService = tweetService;
    this.currentUserProfileApiService = currentUserProfileApiService;
    this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
  }

  @Override
  public List<TweetResponse> findTweets(TweetFindRequest tweetFindRequest) {
    UserProfile owner = this.currentUserProfileApiService.currentUserProfile();
    return this.tweetService.findAllTweets(owner)
        .stream()
        .map(tweetToTweetResponseMapper::map)
        .toList();
  }
}
