package dev.petproject.twitter.subscription.usecase;

import dev.petproject.twitter.subscription.web.model.FollowerFindRequest;
import dev.petproject.twitter.subscription.web.model.FollowerPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface SubscriptionFindFollowerUseCase {

  FollowerPageResponse findFollowers(@Valid FollowerFindRequest findRequest);
}
