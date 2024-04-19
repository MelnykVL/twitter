package dev.petproject.twitter.subscription.converter;

import dev.petproject.twitter.subscription.model.Subscription;
import dev.petproject.twitter.subscription.web.model.UnsubscribeRequest;
import org.springframework.core.convert.converter.Converter;

public interface UnsubscribeRequestToSubscriptionConverter extends Converter<UnsubscribeRequest, Subscription> { }
