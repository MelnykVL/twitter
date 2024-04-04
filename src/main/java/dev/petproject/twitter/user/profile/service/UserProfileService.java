package dev.petproject.twitter.user.profile.service;

import dev.petproject.twitter.user.profile.model.UserProfile;
import java.util.Optional;

public interface UserProfileService {

  void createUserProfile(UserProfile userProfile);

  Optional<UserProfile> findUserProfileById(long userProfileId);
}
