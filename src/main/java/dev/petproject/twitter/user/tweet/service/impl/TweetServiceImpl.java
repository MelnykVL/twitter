package dev.petproject.twitter.user.tweet.service.impl;

import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.repository.TweetRepository;
import dev.petproject.twitter.user.tweet.service.TweetService;

public class TweetServiceImpl implements TweetService {

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return this.tweetRepository.save(tweet);
    }
}
