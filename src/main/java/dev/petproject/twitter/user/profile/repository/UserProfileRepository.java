package dev.petproject.twitter.user.profile.repository;

import dev.petproject.twitter.user.profile.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

  boolean existsByNickname(String nickname);
}
