package dev.petproject.twitter.user.tweet.converter;

import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetEditRequest;
import org.springframework.core.convert.converter.Converter;

public interface TweetEditRequestToTweetConverter extends Converter<TweetEditRequest, Tweet> { }
