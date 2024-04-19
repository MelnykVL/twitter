package dev.petproject.twitter.user.profile.usecase.impl;

import dev.petproject.twitter.user.profile.converter.UserProfileRegisterRequestToUserProfileConverter;
import dev.petproject.twitter.user.profile.model.UserProfile;
import dev.petproject.twitter.user.profile.service.UserProfileService;
import dev.petproject.twitter.user.profile.usecase.UserProfileRegisterUseCase;
import dev.petproject.twitter.user.profile.web.model.UserProfileRegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

  private final UserProfileService userProfileService;
  private final UserProfileRegisterRequestToUserProfileConverter converter;

  public UserProfileRegisterUseCaseFacade(UserProfileService userProfileService,
      UserProfileRegisterRequestToUserProfileConverter converter) {
    this.userProfileService = userProfileService;
    this.converter = converter;
  }

  @Override
  public void registerUserProfile(UserProfileRegisterRequest registerRequest) {
    UserProfile userProfile = this.converter.convert(registerRequest);
    this.userProfileService.createUserProfile(userProfile);
  }
}
