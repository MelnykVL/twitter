package dev.petproject.twitter.subscription.web.model;

import jakarta.validation.constraints.NotNull;

public record UnsubscribeRequest(@NotNull Long followedId) { }
