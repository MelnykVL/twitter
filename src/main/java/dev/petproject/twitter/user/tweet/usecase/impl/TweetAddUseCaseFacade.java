package dev.petproject.twitter.user.tweet.usecase.impl;

import dev.petproject.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import dev.petproject.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.service.TweetService;
import dev.petproject.twitter.user.tweet.usecase.TweetAddUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetAddUseCaseFacade implements TweetAddUseCase {

    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;

    public TweetAddUseCaseFacade(TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper,
            TweetToTweetResponseMapper tweetToTweetResponseMapper, TweetService tweetService) {
        this.tweetAddRequestToTweetMapper = tweetAddRequestToTweetMapper;
        this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
        this.tweetService = tweetService;
    }

    @Override
    public TweetResponse addTweet(TweetAddRequest tweetAddRequest) {
        // TODO: Debug this
        Tweet mappedTweet = this.tweetAddRequestToTweetMapper.map(tweetAddRequest);
        Tweet createdTweet = tweetService.createTweet(mappedTweet);
        return this.tweetToTweetResponseMapper.map(createdTweet);
    }
}
