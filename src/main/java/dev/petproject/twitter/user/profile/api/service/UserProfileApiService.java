package dev.petproject.twitter.user.profile.api.service;

import dev.petproject.twitter.user.profile.model.UserProfile;

public interface UserProfileApiService {

  UserProfile currentUserProfile();

  UserProfile findUserProfileById(long userProfileId);
}
