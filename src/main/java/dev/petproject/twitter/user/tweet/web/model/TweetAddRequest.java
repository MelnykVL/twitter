package dev.petproject.twitter.user.tweet.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TweetAddRequest(@NotBlank @Size(max = 280) String message) {}
