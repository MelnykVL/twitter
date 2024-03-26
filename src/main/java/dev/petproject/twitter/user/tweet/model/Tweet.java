package dev.petproject.twitter.user.tweet.model;

import dev.petproject.twitter.user.profile.model.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;
    @ManyToOne(optional = false)
    private UserProfile userProfile;
}
