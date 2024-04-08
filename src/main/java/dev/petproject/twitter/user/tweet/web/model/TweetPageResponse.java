package dev.petproject.twitter.user.tweet.web.model;

import java.util.List;

public record TweetPageResponse(long totalTweets, boolean isFirstPage, boolean isLastPage,
                                List<TweetResponse> tweets) { }
