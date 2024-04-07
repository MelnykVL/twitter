package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.user.profile.api.service.CurrentUserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetFindUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetFindRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;

import static dev.petproject.twitter.user.tweet.model.Tweet_.CREATED_TIMESTAMP;

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
    Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIMESTAMP);
    Pageable pageable = PageRequest.of(tweetFindRequest.page(), tweetFindRequest.limit(), sort);
    return this.tweetService.findAllTweets(owner, pageable)
        .stream()
        .map(tweetToTweetResponseMapper::map)
        .toList();
  }
}
