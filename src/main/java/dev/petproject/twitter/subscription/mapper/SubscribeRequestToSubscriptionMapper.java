package dev.petproject.twitter.subscription.mapper;

import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.SubscribeRequest;
import org.springframework.core.convert.converter.Converter;

public interface SubscribeRequestToSubscriptionMapper extends Converter<SubscribeRequest, Subscription> { }
