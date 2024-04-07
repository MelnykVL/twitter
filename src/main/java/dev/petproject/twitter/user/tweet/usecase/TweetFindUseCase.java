package dev.petproject.twitter.user.tweet.usecase;

import dev.petproject.twitter.user.tweet.web.model.TweetFindRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Validated
public interface TweetFindUseCase {

  List<TweetResponse> findTweets(@Valid TweetFindRequest tweetFindRequest);
}
