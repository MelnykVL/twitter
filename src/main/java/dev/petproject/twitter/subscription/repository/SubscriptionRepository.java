package dev.petproject.twitter.subscription.repository;

import dev.petproject.twitter.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> { }
