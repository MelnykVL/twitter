package dev.petproject.twitter.user.tweet.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetEditRequest(@NotNull long id, @NotBlank @Size(min = 1, max = 280) String message) {
}
