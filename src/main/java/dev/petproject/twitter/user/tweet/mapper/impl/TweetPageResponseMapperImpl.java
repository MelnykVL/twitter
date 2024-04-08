package dev.petproject.twitter.user.tweet.mapper.impl;

import dev.petproject.twitter.user.tweet.mapper.TweetPageResponseMapper;
import dev.petproject.twitter.user.tweet.mapper.TweetToTweetResponseMapper;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetPageResponse;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TweetPageResponseMapperImpl implements TweetPageResponseMapper {

  private final TweetToTweetResponseMapper tweetToTweetResponseMapper;

  public TweetPageResponseMapperImpl(TweetToTweetResponseMapper tweetToTweetResponseMapper) {
    this.tweetToTweetResponseMapper = tweetToTweetResponseMapper;
  }

  @Override
  public TweetPageResponse map(Page<Tweet> tweets) {
    List<TweetResponse> tweetResponseList = tweets.stream()
        .map(this.tweetToTweetResponseMapper::map)
        .toList();

    return new TweetPageResponse(tweets.getTotalElements(), tweets.isFirst(), tweets.isLast(), tweetResponseList);
  }
}
