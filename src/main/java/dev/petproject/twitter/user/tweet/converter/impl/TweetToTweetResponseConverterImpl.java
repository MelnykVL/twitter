package dev.petproject.twitter.user.tweet.converter.impl;

import dev.petproject.twitter.user.tweet.converter.TweetToTweetResponseConverter;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponseConverterImpl implements TweetToTweetResponseConverter {

  @Override
  public TweetResponse convert(Tweet tweet) {
    return new TweetResponse(tweet.getId(), tweet.getMessage(), tweet.getCreatedTimestamp(),
        tweet.getModifiedTimestamp());
  }
}
