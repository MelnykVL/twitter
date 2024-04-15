package dev.petproject.twitter.subscription.mapper;

import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;
import org.springframework.core.convert.converter.Converter;

public interface UnsubscribeRequestToSubscriptionMapper extends Converter<UnsubscribeRequest, Subscription> { }
