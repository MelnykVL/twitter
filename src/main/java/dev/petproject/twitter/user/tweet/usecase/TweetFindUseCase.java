package dev.petproject.twitter.user.tweet.usecase;

import dev.petproject.twitter.user.tweet.web.model.TweetFindRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TweetFindUseCase {

  TweetPageResponse findTweets(@Valid TweetFindRequest tweetFindRequest);
}
