package dev.petproject.twitter.subscription.web.model;

import java.util.List;

public record FollowerPageResponse(long totalFollowers, boolean isFirstPage, boolean isLastPage,
                                   List<FollowerResponse> followers) { }
