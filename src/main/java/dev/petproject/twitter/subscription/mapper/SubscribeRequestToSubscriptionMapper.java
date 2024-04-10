package dev.petproject.twitter.subscription.mapper;

import dev.petproject.twitter.security.mapper.Mapper;
import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.SubscribeRequest;

public interface SubscribeRequestToSubscriptionMapper extends Mapper<Subscription, SubscribeRequest> { }
