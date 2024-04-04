package dev.petproject.twitter.user.profile.usecase;

import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {

  void registerUserProfile(UserProfileRegisterRequest userProfileRegisterRequest);
}
