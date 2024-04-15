package dev.petproject.twitter.user.tweet.mapper;

import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import org.springframework.core.convert.converter.Converter;

public interface TweetAddRequestToTweetMapper extends Converter<TweetAddRequest, Tweet> { }
