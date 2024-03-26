package dev.petproject.twitter.user.tweet.web;

import dev.petproject.twitter.user.tweet.usecase.TweetAddUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;

    public TweetController(TweetAddUseCase tweetAddUseCase) {
        this.tweetAddUseCase = tweetAddUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest tweetAddRequest) {
        return this.tweetAddUseCase.addTweet(tweetAddRequest);
    }
}
