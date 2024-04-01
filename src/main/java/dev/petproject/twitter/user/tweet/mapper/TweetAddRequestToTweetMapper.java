package dev.petproject.twitter.user.tweet.mapper;

import dev.petproject.twitter.security.mapper.Mapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;

public interface TweetAddRequestToTweetMapper extends Mapper<Tweet, TweetAddRequest> {
}
