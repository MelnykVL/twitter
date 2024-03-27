package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.user.profile.api.service.CurrentUserProfileApiService;
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
    private final CurrentUserProfileApiService currentUserProfileApiService;

    public TweetEditUseCaseFacade(TweetService tweetService,
            TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper,
            TweetToTweetResponseMapper tweetToTweetResponseMapper,
            CurrentUserProfileApiService currentUserProfileApiService) {
        this.tweetService = tweetService;
        this.tweetEditRequestToTweetMapper = tweetEditRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.currentUserProfileApiService = currentUserProfileApiService;
    }

    @Override
    public TweetResponse editTweet(TweetEditRequest tweetEditRequest) {
        UserProfile actor = this.currentUserProfileApiService.currentUserProfile();
        UserProfile owner = this.tweetService.findTweetById(tweetEditRequest.id())
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Tweet with Id = %d does not exist.", tweetEditRequest.id());
                    return new RuntimeException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String.format(
                    "You cannot edit the tweet with Id = %d. User %s is not owner of the tweet.",
                    tweetEditRequest.id(),
                    actor.getNickname());
            throw new RuntimeException(errorMessage);
        }

        // TODO: Debug this
        Tweet tweet = this.tweetEditRequestToTweetMapper.map(tweetEditRequest);
        Tweet updatedTweet = this.tweetService.updateTweet(tweet);

        return this.tweetToTweetResponseMapper.map(updatedTweet);
    }
}
