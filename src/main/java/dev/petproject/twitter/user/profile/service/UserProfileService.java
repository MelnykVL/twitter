package dev.petproject.twitter.user.profile.service;

import dev.petproject.twitter.user.profile.model.UserProfile;

public interface UserProfileService {

  void createUserProfile(UserProfile userProfile);

  UserProfile findUserProfileById(long userProfileId);
}
