package dev.petproject.twitter.user.tweet.converter.impl;

import dev.petproject.twitter.user.tweet.converter.TweetPageResponseConverter;
import dev.petproject.twitter.user.tweet.converter.TweetToTweetResponseConverter;
import dev.petproject.twitter.user.tweet.model.Tweet;
import dev.petproject.twitter.user.tweet.web.model.TweetPageResponse;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TweetPageResponseConverterImpl implements TweetPageResponseConverter {

  private final TweetToTweetResponseConverter tweetToTweetResponseConverter;

  public TweetPageResponseConverterImpl(TweetToTweetResponseConverter tweetToTweetResponseConverter) {
    this.tweetToTweetResponseConverter = tweetToTweetResponseConverter;
  }

  @Override
  public TweetPageResponse convert(Page<Tweet> tweets) {
    List<TweetResponse> tweetResponseList = tweets.stream()
        .map(this.tweetToTweetResponseConverter::convert)
        .toList();

    return new TweetPageResponse(tweets.getTotalElements(), tweets.isFirst(), tweets.isLast(), tweetResponseList);
  }
}
