package dev.petproject.twitter.user.tweet.web.model;

import java.util.List;

public record TweetPageResponse(List<TweetResponse> tweets) { }
