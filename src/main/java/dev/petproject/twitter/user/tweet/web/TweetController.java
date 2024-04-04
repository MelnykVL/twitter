package dev.petproject.twitter.user.tweet.web;

import dev.petproject.twitter.user.tweet.usecase.TweetAddUseCase;
import dev.petproject.twitter.user.tweet.usecase.TweetDeleteUseCase;
import dev.petproject.twitter.user.tweet.usecase.TweetEditUseCase;
import dev.petproject.twitter.user.tweet.web.model.TweetAddRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetEditRequest;
import dev.petproject.twitter.user.tweet.web.model.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUseCase tweetAddUseCase;
    private final TweetEditUseCase tweetEditUseCase;
    private final TweetDeleteUseCase tweetDeleteUseCase;

    public TweetController(TweetAddUseCase tweetAddUseCase, TweetEditUseCase tweetEditUseCase, TweetDeleteUseCase tweetDeleteUseCase) {
        this.tweetAddUseCase = tweetAddUseCase;
        this.tweetEditUseCase = tweetEditUseCase;
        this.tweetDeleteUseCase = tweetDeleteUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest tweetAddRequest) {
        return this.tweetAddUseCase.addTweet(tweetAddRequest);
    }

    @PutMapping
    public TweetResponse editTweet(@Valid @RequestBody TweetEditRequest tweetEditRequest) {
        return this.tweetEditUseCase.editTweet(tweetEditRequest);
    }

    @DeleteMapping("/{tweetId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTweet(@PathVariable long tweetId) {
        tweetDeleteUseCase.deleteTweet(tweetId);
    }
}