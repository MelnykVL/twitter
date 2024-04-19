package dev.petproject.twitter.user.tweet.converter;

import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.core.convert.converter.Converter;

public interface TweetToTweetResponseConverter extends Converter<Tweet, TweetResponse> { }
