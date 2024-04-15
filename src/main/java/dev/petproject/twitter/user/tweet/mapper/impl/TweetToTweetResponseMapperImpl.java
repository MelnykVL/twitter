package dev.petproject.twitter.user.tweet.mapper.impl;

import dev.petproject.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponseMapperImpl implements TweetToTweetResponseMapper {

  @Override
  public TweetResponse convert(Tweet tweet) {
    return new TweetResponse(tweet.getId(), tweet.getMessage(), tweet.getCreatedTimestamp(),
        tweet.getModifiedTimestamp());
  }
}
