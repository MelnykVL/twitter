package dev.petproject.twitter.subscription.converter;

import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.SubscribeRequest;
import org.springframework.core.convert.converter.Converter;

public interface SubscribeRequestToSubscriptionConverter extends Converter<SubscribeRequest, Subscription> { }
