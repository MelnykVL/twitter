package dev.petproject.twitter.subscription.model;

import dev.petproject.twitter.user.profile.model.UserProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(schema = "twitter", name = "subscriptions")
@EntityListeners(AuditingEntityListener.class)
public class Subscription {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  private UserProfile follower;
  @OneToOne
  private UserProfile followed;
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private Instant createdTimestamp;
}
