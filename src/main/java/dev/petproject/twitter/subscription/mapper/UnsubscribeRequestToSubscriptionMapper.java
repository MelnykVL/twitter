package dev.petproject.twitter.subscription.mapper;

import dev.petproject.twitter.security.mapper.Mapper;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;

public interface UnsubscribeRequestToSubscriptionMapper extends Mapper<Subscription, UnsubscribeRequest> { }
