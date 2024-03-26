package dev.petproject.twitter.user.tweet.mapper.impl;

import dev.petproject.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;

public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {

    @Override
    public Tweet map(TweetAddRequest tweetAddRequest) {
        Tweet tweet = new Tweet();
        tweet.setMessage(tweetAddRequest.message());
        tweet.setUserProfile();

        return tweet;
    }
}
