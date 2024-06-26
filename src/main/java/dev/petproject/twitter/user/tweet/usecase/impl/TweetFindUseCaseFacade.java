package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.user.profile.api.service.UserProfileApiService;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.tweet.converter.TweetPageResponseConverter;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetFindUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetFindRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetPageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import static dev.petproject.twitter.user.tweet.model.Tweet_.CREATED_TIMESTAMP;

@Component
public class TweetFindUseCaseFacade implements TweetFindUseCase {

  private final TweetService tweetService;
  private final UserProfileApiService userProfileApiService;
  private final TweetPageResponseConverter tweetPageResponseConverter;

  public TweetFindUseCaseFacade(TweetService tweetService, UserProfileApiService userProfileApiService,
      TweetPageResponseConverter tweetPageResponseConverter) {
    this.tweetService = tweetService;
    this.userProfileApiService = userProfileApiService;
    this.tweetPageResponseConverter = tweetPageResponseConverter;
  }

  @Override
  public TweetPageResponse findTweets(TweetFindRequest tweetFindRequest) {
    UserProfile owner = this.userProfileApiService.currentUserProfile();
    Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIMESTAMP);
    Pageable pageable = PageRequest.of(tweetFindRequest.page(), tweetFindRequest.limit(), sort);
    Page<Tweet> pageableTweets = this.tweetService.findAllTweets(owner, pageable);

    return this.tweetPageResponseConverter.convert(pageableTweets);
  }
}
