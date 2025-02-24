package dev.petproject.twitter.subscription.web;

import dev.petproject.twitter.subscription.usecase.SubscriptionAddUseCase;
import dev.petproject.twitter.subscription.usecase.SubscriptionDeleteUseCase;
import dev.petproject.twitter.subscription.usecase.SubscriptionFindFollowerUseCase;
import dev.petproject.twitter.subscription.web.model.FollowerFindRequest;
import dev.petproject.twitter.subscription.web.model.FollowerPageResponse;
import dev.petproject.twitter.subscription.web.model.SubscribeRequest;
import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

  private final SubscriptionAddUseCase subscriptionAddUseCase;
  private final SubscriptionDeleteUseCase subscriptionDeleteUseCase;
  private final SubscriptionFindFollowerUseCase subscriptionFindFollowerUseCase;

  public SubscriptionController(SubscriptionAddUseCase subscriptionAddUseCase,
      SubscriptionDeleteUseCase subscriptionDeleteUseCase,
      SubscriptionFindFollowerUseCase subscriptionFindFollowerUseCase) {
    this.subscriptionAddUseCase = subscriptionAddUseCase;
    this.subscriptionDeleteUseCase = subscriptionDeleteUseCase;
    this.subscriptionFindFollowerUseCase = subscriptionFindFollowerUseCase;
  }

  @PostMapping("/subscribe")
  public void subscribe(@Valid @RequestBody SubscribeRequest subscribeRequest) {
    this.subscriptionAddUseCase.subscribe(subscribeRequest);
  }

  @PostMapping("/unsubscribe")
  public void unsubscribe(@Valid @RequestBody UnsubscribeRequest unsubscribeRequest) {
    this.subscriptionDeleteUseCase.unsubscribe(unsubscribeRequest);
  }

  @GetMapping("/followers")
  public FollowerPageResponse allFollowers(@RequestParam Integer page, @RequestParam Integer limit) {
    FollowerFindRequest findRequest = new FollowerFindRequest(page, limit);
    return this.subscriptionFindFollowerUseCase.findFollowers(findRequest);
  }
}
